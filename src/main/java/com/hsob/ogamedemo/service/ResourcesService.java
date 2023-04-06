package com.hsob.ogamedemo.service;

import com.hsob.ogamedemo.dto.resource.request.ResourceRequest;
import com.hsob.ogamedemo.model.resources.Resources;
import com.hsob.ogamedemo.repository.ResourceDefinitionsRepository;
import com.hsob.ogamedemo.repository.ResourcesRepository;
import com.hsob.ogamedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourcesService {

    @Autowired
    private ResourcesRepository resourcesRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResourceDefinitionsRepository resourceDefinitionsRepository;
    public ResourceRequest createNewResource(ResourceRequest resourceRequest) {
        try {
            checkExistingUser(resourceRequest.userId());
            checkExistingResourceDefinition(resourceRequest.resourceDefinitionsId());
            var resource = new Resources(resourceRequest);
            resourcesRepository.save(resource);
            return resourceRequest;
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    private void checkExistingResourceDefinition(String resourceDefinitionsId) {
        if (resourceDefinitionsRepository.findById(resourceDefinitionsId).isEmpty()){
            throw new RuntimeException("Resource Definition for id " + resourceDefinitionsId + " not found");
        }
    }

    private void checkExistingUser(String userId) {
        if (userRepository.findById(userId).isEmpty()){
            throw new RuntimeException("User for id " + userId + " not found");
        }
    }
}
