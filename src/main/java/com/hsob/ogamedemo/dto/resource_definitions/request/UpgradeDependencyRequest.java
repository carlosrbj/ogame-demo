package com.hsob.ogamedemo.dto.resource_definitions.request;

public record UpgradeDependencyRequest(
        String type,
        String name,
        String level,
        Integer quantity) {
}
