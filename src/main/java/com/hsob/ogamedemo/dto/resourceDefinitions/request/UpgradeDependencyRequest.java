package com.hsob.ogamedemo.dto.resourceDefinitions.request;

public record UpgradeDependencyRequest(
        String type,
        String name,
        String level,
        Integer quantity) {
}
