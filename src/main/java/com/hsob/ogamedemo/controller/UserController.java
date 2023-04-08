package com.hsob.ogamedemo.controller;

import com.hsob.ogamedemo.dto.user.request.UserRequest;
import com.hsob.ogamedemo.dto.user.response.UserResponse;
import com.hsob.ogamedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userservice;
    @PostMapping("/create")
    public ResponseEntity<UserRequest> createNewUser(@RequestBody UserRequest userRequest, UriComponentsBuilder uriBuilder){
        var user = userservice.createNewUser(userRequest);
        var uri = uriBuilder.path("/user/create/{_id}").buildAndExpand(user).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<UserResponse> getUserById(@RequestHeader String id){
        return ResponseEntity.ok(userservice.getUserById(id));
    }
}
