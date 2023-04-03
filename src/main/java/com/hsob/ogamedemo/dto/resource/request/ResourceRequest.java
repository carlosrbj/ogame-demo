package com.hsob.ogamedemo.dto.resource.request;

import com.hsob.ogamedemo.dto.resource.request.IconRequest;
import com.hsob.ogamedemo.dto.resource.request.LevelDefinitionsRequest;
import lombok.NonNull;

import java.util.List;

public record ResourceRequest(
        @NonNull
        String type,
        @NonNull
        String name,
        @NonNull
        String image,
        @NonNull
        List<IconRequest> icons,
        @NonNull
        List<LevelDefinitionsRequest> levelDefinitions) {
}
