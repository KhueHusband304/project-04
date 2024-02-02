package com.fpt.apiservice.requests.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SignUpRequest {
    @NotEmpty(message = "First name is not empty")
    private String firstName;
    @NotEmpty(message = "Last name is not empty")
    private String lastName;

    @NotEmpty(message = "email is not empty")
    @Email(message = "Email is a@gmail.com ....")
    private String email;

    @NotNull(message = "Phone number is required")
    private Long phone;

    @NotEmpty(message = "Password is not empty")
    private String password;
}
