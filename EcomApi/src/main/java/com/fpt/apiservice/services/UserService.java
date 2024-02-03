package com.fpt.apiservice.services;


import com.fpt.apiservice.mails.MailUserVerificationCode;
import com.fpt.apiservice.models.User;
import com.fpt.apiservice.repositories.UserRepository;
import com.fpt.apiservice.requests.auth.LoginRequest;
import com.fpt.apiservice.requests.auth.SignUpRequest;
import com.fpt.apiservice.requests.user.UserRequest;
import com.fpt.apiservice.responses.auth.AuthResponse;
import com.fpt.apiservice.utils.JwtUtil;
import com.fpt.apiservice.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    MailUserVerificationCode mailUserVerificationCode;

    /**
     * Create user
     *
     * @param signupRequest
     * @return
     */
    public User createUser(SignUpRequest signupRequest) {

        signupRequest.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        ModelMapperUtil<User, SignUpRequest> mapper = new ModelMapperUtil<>();
        User user = mapper.mapToModel(signupRequest, new User());

        mailUserVerificationCode.sendMail(user.getEmail(), "code");

        return userRepository.save(user);
    }

    /**
     * Login
     *
     * @param loginReq
     * @return
     * @throws Exception
     */
    public AuthResponse login(LoginRequest loginReq) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getEmail(), loginReq.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String email = authentication.getName();
            User user = userRepository.findByEmail(email);

            return AuthResponse.builder().token(jwtUtil.generateToken(user)).email(user.getEmail())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .address(user.getAddress())
                    .phone(user.getPhone())
                    .avatar(user.getAvatar())
                    .errorMess(null)
                    .is_verified(user.isVerified())
                    .build();

        } catch (Exception e) {
            throw new Exception("email or password incorrect");
        }
    }


    /**
     * Find user by email
     *
     * @param email
     * @return
     */
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Verify user
     *
     * @param email
     * @return
     */
    public User verifyUser(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null && !user.isVerified()) {
            user.setVerified(true);
            user.prePersist();

            return user;
        }
        return null;
    }

    public ResponseEntity<User> getSingleUser(Integer userId) {
        Optional<User> userData = userRepository.findById(userId);
        if (userData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(userData.get(), HttpStatus.OK);
    }

    //update user [service]
    public ResponseEntity<User> updateUser(Integer userId, UserRequest request) {
        Optional<User> userData = userRepository.findById(userId);
        if (userData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (request.address() != null)
            userData.get().setAddress(request.address());
        if (request.phone() != null)
            userData.get().setPhone(request.phone());
        if (request.password() != null)
            userData.get().setPassword(passwordEncoder.encode(request.password()));
        if (request.firstName() != null)
            userData.get().setFirstName(request.firstName());
        if (request.lastName() != null)
            userData.get().setLastName(request.lastName());
        if (request.avatar() != null)
            userData.get().setAvatar(request.avatar());


        return new ResponseEntity<User>(
                userRepository.save(userData.get()),
                HttpStatus.OK);
    }

    //delete user [service]
    public ResponseEntity deleteUser(Integer userId) {
        Optional<User> userData = userRepository.findById(userId);
        if (userData.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userRepository.deleteById(userId);

        return new ResponseEntity(HttpStatus.OK);
    }

    //get all user [service - admin]
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }


}
