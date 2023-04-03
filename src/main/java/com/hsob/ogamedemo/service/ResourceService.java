package com.hsob.ogamedemo.service;

import com.hsob.ogamedemo.dto.resource.request.ResourceRequest;
import com.hsob.ogamedemo.dto.resource.ResourceResponse;
import com.hsob.ogamedemo.model.resources.Resources;
import com.hsob.ogamedemo.repository.ResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {

    @Autowired
    private ResourcesRepository resourcesRepository;

    public ResourceRequest createNewResource(ResourceRequest resourceRequest){
        try {
            var resource = new Resources(resourceRequest);
            resourcesRepository.save(resource);
            return resourceRequest;
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
