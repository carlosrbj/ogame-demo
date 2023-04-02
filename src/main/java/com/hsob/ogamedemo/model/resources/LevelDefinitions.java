package com.hsob.ogamedemo.model.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LevelDefinitions {
    private String level;
    private Status status;
    private Integer quantityPerSecond;
    private Double productionInterval;
    private List<NextLevelDependency> nextLevelDependencies;

    public LevelDefinitions(String level, Integer quantityPerSecond, Double productionInterval, List<NextLevelDependency> nextLevelDependencies) {
        this.level = level;
        this.quantityPerSecond = quantityPerSecond;
        this.productionInterval = productionInterval;
        this.nextLevelDependencies = nextLevelDependencies;
    }
}
