package com.hsob.ogamedemo.model.resources;

import com.hsob.ogamedemo.dto.resourceDefinitions.request.UpgradeDependencyRequest;
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
public class UpgradeDependency {
    private String type;
    private String name;
    private String level;
    private Integer quantity;

    public UpgradeDependency(UpgradeDependencyRequest request) {
        this.type = request.type();
        this.name = request.name();
        this.level = request.level();
        this.quantity = request.quantity();
    }

    public List<UpgradeDependency> createList(List<UpgradeDependencyRequest> upgradeDependencies) {
        List<UpgradeDependency> list = new ArrayList<>();
        upgradeDependencies.forEach(i -> list.add(new UpgradeDependency(i)));
        return list;
    }
}
