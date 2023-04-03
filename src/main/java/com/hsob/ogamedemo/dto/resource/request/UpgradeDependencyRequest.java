package com.hsob.ogamedemo.dto.resource.request;

public record UpgradeDependencyRequest(
        String type,
        String name,
        String level,
        Integer quantity) {
}
