package com.hsob.ogamedemo.service;

import com.hsob.ogamedemo.dto.resource.request.ResourceDefinitionsRequest;
import com.hsob.ogamedemo.model.resources.Resources;
import com.hsob.ogamedemo.model.resources_definitions.ResourceDefinitions;
import com.hsob.ogamedemo.repository.ResourceDefinitionsRepository;
import com.hsob.ogamedemo.repository.ResourcesRepository;
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
