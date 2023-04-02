package com.hsob.ogamedemo.model.user;

import com.hsob.ogamedemo.model.resources.Resources;
import com.hsob.ogamedemo.model.resources.UserResources;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User {
    private @MongoId ObjectId id;
    private String name;
    private List<Resources> resources;

    public User(String name, List<Resources> resources) {
        this.name = name;
        this.resources = resources;
    }

    public List<User> populateDbFirstTime() {
        List<User> users = new ArrayList<>();
        users.add(new User("Carlos", new Resources().populateUser()));
        users.add(new User("Bruno", new Resources().populateUser()));
        return users;
    }
}
