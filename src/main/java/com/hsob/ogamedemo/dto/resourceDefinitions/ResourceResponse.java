package com.hsob.ogamedemo.dto.resourceDefinitions;

import com.hsob.ogamedemo.dto.resourceDefinitions.request.IconRequest;
import com.hsob.ogamedemo.dto.resourceDefinitions.request.LevelDefinitionsRequest;

import java.util.List;

public record ResourceResponse(String type, String name, String image, List<IconRequest> icons, List<LevelDefinitionsRequest> levelDefinitions) {
}
