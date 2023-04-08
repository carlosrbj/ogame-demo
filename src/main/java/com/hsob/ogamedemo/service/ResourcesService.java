package com.hsob.ogamedemo.service;

import com.hsob.ogamedemo.dto.resource.request.ResourceRequest;
import com.hsob.ogamedemo.dto.resource.response.ResourceResponse;
import com.hsob.ogamedemo.dto.resource_definitions.response.ResourceDefinitionsResponse;
import com.hsob.ogamedemo.dto.user.response.UserResponse;
import com.hsob.ogamedemo.model.resources.Resources;
import com.hsob.ogamedemo.model.resources_definitions.ResourceDefinitions;
import com.hsob.ogamedemo.repository.ResourceDefinitionsRepository;
import com.hsob.ogamedemo.repository.ResourcesRepository;
import com.hsob.ogamedemo.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void checkExistingResourceDefinition(String resourceDefinitionsId) {
        if (resourceDefinitionsRepository.findById(resourceDefinitionsId).isEmpty()){
            throw new IllegalArgumentException("Resource Definition for id " + resourceDefinitionsId + "not found");
        }
    }

    private void checkExistingUser(String userId) {
        if (userRepository.findById(userId).isEmpty()) {
            throw new IllegalArgumentException("User for id " + userId + " not found");
        }
    }

    public List<ResourceResponse> getResourcesByUserId(String userId) {
        List<ResourceResponse> resourcesList = new ArrayList<>();
        List<String> definitionsIdList = new ArrayList<>();

        try {
            var user = userRepository.findById(userId);
            if (user.isEmpty()) throw new IllegalArgumentException("User for id " + userId + " not found");

            var resources = resourcesRepository.findByUserId(userId);
            if (resources.isEmpty()) throw new IllegalArgumentException("No resource found for user " + userId);
            resources.forEach(r -> definitionsIdList.add(r.getResourceDefinitionsId()));

            var resourcesDefinitions = resourceDefinitionsRepository.findAllById(definitionsIdList);
            if (resourcesDefinitions.isEmpty()) throw new IllegalArgumentException("No resourceDefinitions found in IdList " + definitionsIdList);

            resources.forEach(resource -> {
                var definitions = getResourceDefinitionsFromList(resource.getResourceDefinitionsId(), resourcesDefinitions);
                resourcesList.add(new ResourceResponse(resource, new UserResponse(user.get()), definitions));
            });
            return resourcesList;
        } catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private ResourceDefinitionsResponse getResourceDefinitionsFromList(String resourceDefinitionsId, List<ResourceDefinitions> list) {
        ResourceDefinitionsResponse resourceDefinitions = null;
        for (ResourceDefinitions rd: list){
            if (rd.getId().equals(new ObjectId(resourceDefinitionsId))) {
                resourceDefinitions = new ResourceDefinitionsResponse(rd);
                list.remove(rd);
                break;
            }
        }
        return resourceDefinitions;
    }

}
