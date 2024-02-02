package com.fpt.apiservice.requests.user;


public record UserRequest(
        String password,
        String firstName,
        String lastName,
        String address,
        Long phone,
        String avatar
) {

}
