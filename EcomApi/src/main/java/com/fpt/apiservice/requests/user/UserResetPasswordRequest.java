package com.fpt.apiservice.requests.user;

import com.fpt.apiservice.models.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResetPasswordRequest{
    private String email;
    private String password;

}
