//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.fpt.apiservice.controller.client.auth;

import com.fpt.apiservice.controller.ApiController;
import com.fpt.apiservice.models.User;
import com.fpt.apiservice.requests.auth.SignUpRequest;
import com.fpt.apiservice.responses.ApiResponse;
import com.fpt.apiservice.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/sign-up"})
public class SignUpController extends ApiController {
    @Autowired
    ApiResponse apiResponse;
    @Autowired
    UserService userService;


    @PostMapping({""})
    public ResponseEntity<?> signUp(@RequestBody @Valid SignUpRequest signupRequest, BindingResult rs) {
        try {
            if (rs.hasErrors()) {
                return this.apiResponse.failure("invalid", this.parseFieldErrors(rs), HttpStatus.UNPROCESSABLE_ENTITY.value());
            } else {
                User user = this.userService.createUser(signupRequest);
                return this.apiResponse.ok("created", user);
            }
        } catch (Exception var4) {
            var4.printStackTrace();
            return this.apiResponse.failure("error");
        }
    }
}
