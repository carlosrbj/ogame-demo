package com.hsob.ogamedemo.model.resources_definitions;

import com.hsob.ogamedemo.dto.resourceDefinitions.request.IconRequest;
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
public class Icon {
    private String type;
    private String name;
    private String src;

    public Icon(IconRequest iconRequest) {
        this.type = iconRequest.type();
        this.name = iconRequest.name();
        this.src = iconRequest.src();
    }

    public List<Icon> createIconList(List<IconRequest> icons) {
        List<Icon> list = new ArrayList<>();
        icons.forEach(i -> list.add(new Icon(i)));
        return list;
    }
}
