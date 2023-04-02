package com.hsob.ogamedemo.model.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResources{
    private String type;
    private LocalDateTime lastUpdate;
    private String level;
    private Double productionInterval;
    private Integer quantityPerSecond;
    private List<LevelDefinitions> levelDefinitions;

}
