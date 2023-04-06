package com.hsob.ogamedemo.model.resources_definitions;

import com.hsob.ogamedemo.dto.resourceDefinitions.request.ResourceDefinitionsRequest;
import com.hsob.ogamedemo.model.resources.Icon;
import com.hsob.ogamedemo.model.resources.LevelDefinitions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "resources_definitions")
public class ResourceDefinitions {
    private @MongoId ObjectId id;
    private String type;
    private String name;
    private String image;
    private List<Icon> icons;
    private List<LevelDefinitions> levelDefinitions;

    public ResourceDefinitions(ResourceDefinitionsRequest request) {
        this.type = request.type();
        this.name = request.name();
        this.image = request.image();
        this.icons = new Icon().createIconList(request.icons());
        this.levelDefinitions = new LevelDefinitions().createLevelList(request.levelDefinitions());
    }
}
