package com.hsob.ogamedemo.model.resources;

import com.hsob.ogamedemo.dto.resourceDefinitions.request.UpgradeDefinitionsRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpgradeDefinitions {
    private Long upgradeDuration;
    private Long energyToUpgrade;
    private List<UpgradeDependency> upgradeDependencies;

    public UpgradeDefinitions(UpgradeDefinitionsRequest request) {
        this.upgradeDuration = request.upgradeDuration();
        this.energyToUpgrade = request.energyToUpgrade();
        this.upgradeDependencies = new UpgradeDependency().createList(request.upgradeDependencies());
    }
}
