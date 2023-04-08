package com.hsob.ogamedemo.service;

import com.hsob.ogamedemo.dto.user.request.UserRequest;
import com.hsob.ogamedemo.dto.user.response.UserResponse;
import com.hsob.ogamedemo.model.user.User;
import com.hsob.ogamedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public UserRequest createNewUser(UserRequest userRequest) {
        try {
            var user = new User(userRequest);
            userRepository.save(user);
            return userRequest;
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public UserResponse getUserById(String id) {
        var user = userRepository.findById(id);
        if (user.isEmpty()) throw new IllegalArgumentException("No user found with id " + id);
        return new UserResponse(user.get());
    }
}
