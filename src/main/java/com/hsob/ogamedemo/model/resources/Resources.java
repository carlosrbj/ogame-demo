package com.hsob.ogamedemo.model.resources;

import com.hsob.ogamedemo.dto.resource.request.ResourceRequest;
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
@Document(collection = "resources")
public class Resources {
    private @MongoId ObjectId id;
    private String type;
    private String name;
    private String image;
    private List<Icon> icons;
    private List<LevelDefinitions> levelDefinitions;

    public Resources(ResourceRequest resourceRequest) {
        this.type = resourceRequest.type();
        this.name = resourceRequest.name();
        this.image = resourceRequest.image();
        this.icons = new Icon().createIconList(resourceRequest.icons());
        this.levelDefinitions = new LevelDefinitions().createLevelList(resourceRequest.levelDefinitions());
    }
}
