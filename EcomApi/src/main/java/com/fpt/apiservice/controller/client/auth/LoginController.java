
package com.fpt.apiservice.controller.client.auth;

import com.fpt.apiservice.controller.ApiController;
import com.fpt.apiservice.requests.auth.LoginRequest;
import com.fpt.apiservice.responses.ApiResponse;
import com.fpt.apiservice.responses.auth.AuthResponse;
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
@RequestMapping({"api/v1"})
public class LoginController extends ApiController {
    @Autowired
    ApiResponse apiResponse;
    @Autowired
    UserService userService;

    @PostMapping({"/auth"})
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginReq, BindingResult rs) throws Exception {
        try {
            if (rs.hasErrors()) {
                return this.apiResponse.failure("invalid", this.parseFieldErrors(rs), HttpStatus.UNPROCESSABLE_ENTITY.value());
            } else {
                AuthResponse resq = this.userService.login(loginReq);
                return resq != null ? this.apiResponse.ok("login sucees", resq) : this.apiResponse.failure("Invalid email or password");
            }
        } catch (Exception var4) {
            return this.apiResponse.failure(var4.getMessage());
        }
    }
}
