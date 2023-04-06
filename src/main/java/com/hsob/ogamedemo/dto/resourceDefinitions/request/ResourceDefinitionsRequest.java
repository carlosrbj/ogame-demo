package com.hsob.ogamedemo.dto.resourceDefinitions.request;

import lombok.NonNull;

import java.util.List;

public record ResourceDefinitionsRequest(
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
