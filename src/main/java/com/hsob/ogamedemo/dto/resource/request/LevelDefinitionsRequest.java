package com.hsob.ogamedemo.dto.resource.request;

public record LevelDefinitionsRequest(
        String level,
        Double storageCapacity,
        Double productionQuantity,
        Double productionTime,
        UpgradeDefinitionsRequest upgradeDefinitions) {
}
