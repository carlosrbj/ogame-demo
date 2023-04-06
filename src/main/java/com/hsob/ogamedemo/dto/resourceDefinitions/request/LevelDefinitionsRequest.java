package com.hsob.ogamedemo.dto.resourceDefinitions.request;

public record LevelDefinitionsRequest(
        String level,
        Double storageCapacity,
        Double productionQuantity,
        Double productionTime,
        UpgradeDefinitionsRequest upgradeDefinitions) {
}
