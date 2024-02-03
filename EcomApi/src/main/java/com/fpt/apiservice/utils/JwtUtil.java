package com.fpt.apiservice.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fpt.apiservice.models.User;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    public static final String SECRET_KEY = "eProjectFptAptech";

    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", user.getEmail());
        return createToken(claims, user.getEmail());
    }

    private String createToken(Map<String, Object> claims, String email) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY.getBytes());
        return JWT.create()
                .withSubject(email)
                .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 1000 * 24))
                .withClaim("UserInfo", claims)
                .sign(algorithm);
    }
}