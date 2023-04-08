package com.hsob.ogamedemo.dto.resource.response;

import com.hsob.ogamedemo.dto.resource_definitions.response.ResourceDefinitionsResponse;
import com.hsob.ogamedemo.dto.user.response.UserResponse;
import com.hsob.ogamedemo.model.resources.Resources;


public record ResourceResponse(
        String type,
        String name,
        String level,
        String lastUpdate,
        Double resourceAvailable,
        Double storageCapacity,
        Double currentProduction,
        Double hidingCapacity,
        UserResponse user,
        ResourceDefinitionsResponse resourceDefinitions) {

    public ResourceResponse(Resources resources, UserResponse user, ResourceDefinitionsResponse resourceDefinitions) {
        this(
                resources.getType(),
                resources.getName(),
                resources.getLevel(),
                resources.getLastUpdate(),
                resources.getResourceAvailable(),
                resources.getStorageCapacity(),
                resources.getCurrentProduction(),
                resources.getHidingCapacity(),
                user,
                resourceDefinitions
        );
    }
}
