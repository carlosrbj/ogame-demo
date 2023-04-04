package com.hsob.ogamedemo.model.resources;

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
    private String lastUpdate;
    private Double resourceAvailable;
    private Double storageCapacity;
    private Double currentProduction;
    private Double hidingCapacity;
    private ObjectId userId;
    private ObjectId resourceDefinitionsId;
}
