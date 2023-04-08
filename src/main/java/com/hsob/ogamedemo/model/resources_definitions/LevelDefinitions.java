package com.hsob.ogamedemo.model.resources_definitions;

import com.hsob.ogamedemo.dto.resourceDefinitions.request.LevelDefinitionsRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LevelDefinitions {
    private String level;
    private Double storageCapacity;
    private Double productionQuantity;
    private Double productionTime;
    private UpgradeDefinitions upgradeDefinitions;

    public LevelDefinitions(LevelDefinitionsRequest request) {
        this.level = request.level();
        this.storageCapacity = request.storageCapacity();
        this.productionQuantity = request.productionQuantity();
        this.productionTime = request.productionTime();
        this.upgradeDefinitions = new UpgradeDefinitions(request.upgradeDefinitions());
    }

    public List<LevelDefinitions> createLevelList(List<LevelDefinitionsRequest> levelDefinitions) {
        List<LevelDefinitions> list = new ArrayList<>();
        levelDefinitions.forEach(i -> list.add(new LevelDefinitions(i)));
        return list;
    }
}
