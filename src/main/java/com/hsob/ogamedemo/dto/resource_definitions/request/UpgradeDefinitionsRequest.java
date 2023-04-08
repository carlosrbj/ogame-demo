package com.hsob.ogamedemo.dto.resource_definitions.request;

import java.util.List;

public record UpgradeDefinitionsRequest(
        Long upgradeDuration,
        Long energyToUpgrade,
        List<UpgradeDependencyRequest>upgradeDependencies
) {
}
