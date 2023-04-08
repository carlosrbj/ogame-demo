package com.hsob.ogamedemo.service;

import com.hsob.ogamedemo.dto.resourceDefinitions.request.ResourceDefinitionsRequest;
import com.hsob.ogamedemo.dto.resourceDefinitions.response.ResourceDefinitionsResponse;
import com.hsob.ogamedemo.model.resources_definitions.ResourceDefinitions;
import com.hsob.ogamedemo.repository.ResourceDefinitionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<ResourceDefinitionsResponse> getAllResourcesDefinitionsByType(String type) {
        try {
            var list = resourceDefinitionsRepository.findAllByType(type);
            List<ResourceDefinitionsResponse> response = new ArrayList<>();
            if (list.isEmpty()) throw new IllegalArgumentException("No resource found with type " + type);
            list.forEach(l -> response.add(new ResourceDefinitionsResponse(l)));
            return response;
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public ResourceDefinitionsResponse getAllResourcesDefinitionsById(String id) {
        try {
            var resource = resourceDefinitionsRepository.findById(id);
            if (resource.isEmpty()) throw new IllegalArgumentException("No resource found with id " + id);
            return new ResourceDefinitionsResponse(resource.get());
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
