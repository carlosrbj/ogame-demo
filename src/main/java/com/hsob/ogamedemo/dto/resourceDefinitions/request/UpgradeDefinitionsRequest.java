package com.hsob.ogamedemo.dto.resourceDefinitions.request;

import java.util.List;

public record UpgradeDefinitionsRequest(
        Long upgradeDuration,
        Long energyToUpgrade,
        List<UpgradeDependencyRequest>upgradeDependencies
) {
}
