package com.fpt.apiservice.controller.client;

import com.fpt.apiservice.controller.ApiController;
import com.fpt.apiservice.models.User;
import com.fpt.apiservice.requests.user.UserRequest;
import com.fpt.apiservice.responses.ApiResponse;
import com.fpt.apiservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/user")
public class UserController extends ApiController {

    @Autowired
    private ApiResponse apiResponse;
    @Autowired
    private UserService userService;

    // Update user
    @PutMapping(path = "{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Integer id, @RequestBody UserRequest userRequest) {
        return userService.updateUser(id, userRequest);
    }

    //get user all
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return userService.getUsers();
    }

    //get single user
    @GetMapping(path = "{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable("userId") Integer id) {
        return userService.getSingleUser(id);
    }

    //delete user by id
    @DeleteMapping(path = "{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") Integer id) {
        return userService.deleteUser(id);
    }

}