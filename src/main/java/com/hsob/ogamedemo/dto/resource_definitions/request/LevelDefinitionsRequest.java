package com.hsob.ogamedemo.dto.resource_definitions.request;

public record LevelDefinitionsRequest(
        String level,
        Double storageCapacity,
        Double productionQuantity,
        Double productionTime,
        UpgradeDefinitionsRequest upgradeDefinitions) {
}
