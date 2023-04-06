package com.hsob.ogamedemo.model.resources;

import com.hsob.ogamedemo.dto.resource.request.ResourceRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "resources")
public class Resources {
    private @MongoId ObjectId id;
    private String type;
    private String name;
    private String level;
    private String lastUpdate;
    private Double resourceAvailable;
    private Double storageCapacity;
    private Double currentProduction;
    private Double hidingCapacity;
    private ObjectId userId;
    private ObjectId resourceDefinitionsId;

    public Resources(ResourceRequest request) {
        this.type = request.type();
        this.name = request.name();
        this.level = request.level();
        this.lastUpdate = request.lastUpdate();
        this.resourceAvailable = request.resourceAvailable();
        this.storageCapacity = request.storageCapacity();
        this.currentProduction = request.currentProduction();
        this.hidingCapacity = request.hidingCapacity();
        this.userId = new ObjectId(request.userId());
        this.resourceDefinitionsId = new ObjectId(request.resourceDefinitionsId());
    }
}
