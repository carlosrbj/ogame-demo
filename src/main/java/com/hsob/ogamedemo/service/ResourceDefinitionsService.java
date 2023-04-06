package com.hsob.ogamedemo.service;

import com.hsob.ogamedemo.dto.resourceDefinitions.request.ResourceDefinitionsRequest;
import com.hsob.ogamedemo.model.resources_definitions.ResourceDefinitions;
import com.hsob.ogamedemo.repository.ResourceDefinitionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceDefinitionsService {

    @Autowired
    private ResourceDefinitionsRepository resourceDefinitionsRepository;

    public ResourceDefinitionsRequest createNewResourceDefinitions(ResourceDefinitionsRequest resourceDefinitionsRequest){
        try {
            var resource = new ResourceDefinitions(resourceDefinitionsRequest);
            resourceDefinitionsRepository.save(resource);
            return resourceDefinitionsRequest;
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
