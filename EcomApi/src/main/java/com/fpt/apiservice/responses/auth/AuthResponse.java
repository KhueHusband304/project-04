package com.fpt.apiservice.responses.auth;

import com.fpt.apiservice.models.User;
import lombok.*;

import java.util.Date;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthResponse {
    private String token;
    private boolean is_verified;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private Long phone;
    private String avatar;
    private String errorMess;

//    public AuthResponse(String token, Boolean isVerified, String firstName, String address, String lastName, String password, String email, Long phone, String avatar) {
//        this.token = token;
//        this.is_verified = isVerified;
//        this.password = password;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.address = address;
//        this.email = email;
//        this.phone = phone;
//        this.avatar = avatar;
//    }
//
//    public AuthResponse(User user) {
//        this.password = user.getPassword();
//        this.is_verified = user.isVerified();
//        this.firstName = user.getFirstName();
//        this.lastName = user.getLastName();
//        this.address = user.getAddress();
//        this.email = user.getEmail();
//        this.phone = user.getPhone();
//        this.avatar = user.getAvatar();
//    }
//
//    public AuthResponse(String errorMess) {
//        this.errorMess = errorMess;
//    }
}
