package com.hsob.ogamedemo.dto.resource.request;

import java.util.List;

public record UpgradeDefinitionsRequest(
        Long upgradeDuration,
        Long energyToUpgrade,
        List<UpgradeDependencyRequest>upgradeDependencies
) {
}
