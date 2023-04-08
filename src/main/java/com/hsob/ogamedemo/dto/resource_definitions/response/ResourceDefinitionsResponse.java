package com.hsob.ogamedemo.dto.resource_definitions.response;

import com.hsob.ogamedemo.model.resources_definitions.Icon;
import com.hsob.ogamedemo.model.resources_definitions.LevelDefinitions;
import com.hsob.ogamedemo.model.resources_definitions.ResourceDefinitions;

import java.util.List;

public record ResourceDefinitionsResponse (String type, String name, String image, List<Icon> icons, List<LevelDefinitions> levelDefinitions){

    public ResourceDefinitionsResponse(ResourceDefinitions resource) {
        this(resource.getType(), resource.getName(), resource.getImage(), resource.getIcons(), resource.getLevelDefinitions());
    }
}
