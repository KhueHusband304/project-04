package com.fpt.apiservice.responses.auth;

import com.fpt.apiservice.models.User;
import com.fpt.apiservice.types.RoleType;
import lombok.*;

import java.util.Date;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthResponse {
    private Long id;
    private String token;
    private boolean is_verified;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private Long phone;
    private String avatar;

    private RoleType role;
    private String errorMess;
}
