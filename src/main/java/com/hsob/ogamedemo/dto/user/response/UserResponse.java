package com.hsob.ogamedemo.dto.user.response;

import com.hsob.ogamedemo.model.user.User;

public record UserResponse(String name, String username) {

    public UserResponse(User user) {
        this(user.getName(), user.getUsername());
    }
}
