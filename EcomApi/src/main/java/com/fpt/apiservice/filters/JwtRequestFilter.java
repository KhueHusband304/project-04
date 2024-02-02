//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.fpt.apiservice.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpt.apiservice.models.User;
import com.fpt.apiservice.types.RoleType;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    public static final String SECRET_KEY = "eProjectFptAptech";

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorHeader = request.getHeader("Authorization");
        if (authorHeader != null && authorHeader.startsWith("Bearer ")) {
            try {
                String token = authorHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY.getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(token);
                String email = decodedJWT.getSubject();
                User userInfo = (User) decodedJWT.getClaim("UserInfo").as(User.class);
                log.info("Token: " + token);
                log.info("Decoded JWT: " + decodedJWT);
                log.info("UserInfo JSON: " + userInfo);
                //Roletype
                RoleType role = userInfo.getRole();
                String roleStr = (role != null) ? role.toString() : "Role not set";
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(email, (Object) null, Collections.singleton(new SimpleGrantedAuthority(roleStr)));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                filterChain.doFilter(request, response);
            } catch (Exception var13) {
                response.setHeader("error", var13.getMessage());
                response.setStatus(HttpStatus.FORBIDDEN.value());
                Map<String, String> error = new HashMap();
                error.put("error_message", var13.getMessage());
                response.setContentType("application/json");
                (new ObjectMapper()).writeValue(response.getOutputStream(), error);
            }
        } else {
            filterChain.doFilter(request, response);
        }

    }
}
