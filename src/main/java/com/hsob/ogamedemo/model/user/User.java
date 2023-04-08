package com.hsob.ogamedemo.model.user;

import com.hsob.ogamedemo.dto.user.request.UserRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
    private @MongoId ObjectId id;
    private String name;
    private String username;

    public User(UserRequest userRequest) {
        this.name = userRequest.name();
        this.username = userRequest.username();
    }
}
