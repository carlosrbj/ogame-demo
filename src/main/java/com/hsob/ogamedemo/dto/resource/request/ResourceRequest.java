package com.hsob.ogamedemo.dto.resource.request;

import lombok.NonNull;

public record ResourceRequest(
        @NonNull
        String type,
        @NonNull
        String name,
        @NonNull
        String level,
        @NonNull
        String lastUpdate,
        @NonNull
        Double resourceAvailable,
        @NonNull
        Double storageCapacity,
        @NonNull
        Double currentProduction,
        @NonNull
        Double hidingCapacity,
        @NonNull
        String userId,
        @NonNull
        String resourceDefinitionsId) {
}
