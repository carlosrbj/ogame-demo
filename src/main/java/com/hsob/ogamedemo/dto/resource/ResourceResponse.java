package com.hsob.ogamedemo.dto.resource;

import com.hsob.ogamedemo.dto.resource.request.IconRequest;
import com.hsob.ogamedemo.dto.resource.request.LevelDefinitionsRequest;

import java.util.List;

public record ResourceResponse(String type, String name, String image, List<IconRequest> icons, List<LevelDefinitionsRequest> levelDefinitions) {
}
