package com.hsob.ogamedemo.service;

import com.hsob.ogamedemo.model.resources.Resources;
import com.hsob.ogamedemo.model.user.User;
import com.hsob.ogamedemo.repository.ResourcesRepository;
import com.hsob.ogamedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Utils {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResourcesRepository resourcesRepository;

    public  void populateUserDb() {
        userRepository.saveAll(new User().populateDbFirstTime());
    }

    public  void populateResourcesDb() {
        resourcesRepository.saveAll(new Resources().populateDbFirstTime());
    }
}
