package com.hsob.ogamedemo.service;

import com.hsob.ogamedemo.dto.resource_definitions.request.ResourceDefinitionsRequest;
import com.hsob.ogamedemo.dto.resource_definitions.response.ResourceDefinitionsResponse;
import com.hsob.ogamedemo.model.resources_definitions.Icon;
import com.hsob.ogamedemo.model.resources_definitions.ResourceDefinitions;
import com.hsob.ogamedemo.model.user.User;
import com.hsob.ogamedemo.repository.ResourceDefinitionsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceDefinitionsService {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Icon icon = new Icon();
        icon.setName("NOME DO ICONE");
        icon.setType("ICONE TIPO");
        icon.setSrc("SRC DO ICONE");

        User user = new User();
        user.setName("NOME DO USER");
        user.setUsername("USERNAME DO USER");

        var value = System.currentTimeMillis()%2==0 ? icon : user;
        System.out.println(value.getClass().getName());
        for(Method method : value.getClass().getDeclaredMethods()){
            System.out.println(method.getName());
            if(method.getName().contains("get")) {
                System.out.println(method.invoke(value));
            }
        }

    }

    @Autowired
    private ResourceDefinitionsRepository resourceDefinitionsRepository;

    public ResourceDefinitionsRequest createNewResourceDefinitions(ResourceDefinitionsRequest resourceDefinitionsRequest){
        try {
            var resource = new ResourceDefinitions(resourceDefinitionsRequest);
            resourceDefinitionsRepository.save(resource);
            return resourceDefinitionsRequest;
        } catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
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
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public ResourceDefinitionsResponse getAllResourcesDefinitionsById(String id) {
        try {
            var resource = resourceDefinitionsRepository.findById(id);
            if (resource.isEmpty()) throw new IllegalArgumentException("No resource found with id " + id);
            return new ResourceDefinitionsResponse(resource.get());
        }
        catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
