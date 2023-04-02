package com.hsob.ogamedemo.model.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NextLevelDependency {
    private String type;
    private Integer quantity;
}
