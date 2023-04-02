package com.hsob.ogamedemo.model.resources;

import com.hsob.ogamedemo.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "resources")
public class Resources {
    private @MongoId ObjectId id;
    private String type;
    private LocalDateTime lastUpdate;
    private String level;
    private Double productionInterval;
    private Integer quantityPerSecond;
    private List<LevelDefinitions> levelDefinitions;

    public Resources(String type, LocalDateTime lastUpdate, String level, Double productionInterval, Integer quantityPerSecond, List<LevelDefinitions> levelDefinitions) {
        this.type = type;
        this.lastUpdate = lastUpdate;
        this.level = level;
        this.productionInterval = productionInterval;
        this.quantityPerSecond = quantityPerSecond;
        this.levelDefinitions = levelDefinitions;
    }

    public List<Resources> populateDbFirstTime(){
        List<Resources> resourcesList = new ArrayList<>();
        resourcesList.add(new Resources(
                "metal","1", 0.1, 5, createListLevelDefinitions()));
        resourcesList.add(new Resources(
                "cristal", "1",0.12, 5, createListLevelDefinitions()));
        resourcesList.add(new Resources(
                "deuterio", "1", 0.1, 5, createListLevelDefinitions()));

        return resourcesList;
    }

    public List<Resources> populateUser(User user){
        List<Resources> resourcesList = new ArrayList<>();
        resourcesList.add(new Resources(
                "metal", LocalDateTime.now(), "0", 0.1, 5, createListLevelDefinitions(user)));
        resourcesList.add(new Resources(
                "cristal", LocalDateTime.now(), "0",0.12, 5, createListLevelDefinitions()));
        resourcesList.add(new Resources(
                "deuterio", LocalDateTime.now(), "0", 0.1, 5, createListLevelDefinitions()));

        return resourcesList;
    }


    private List<LevelDefinitions> createListLevelDefinitions(User user) {
        List<LevelDefinitions> list = new ArrayList<>();
        Query query = n
        list.add(new LevelDefinitions("0", 1, 0.1, createNextLevelDependecy(2, 2)));
        list.add(new LevelDefinitions("1", 2, 0.11, createNextLevelDependecy(5, 4)));
        list.add(new LevelDefinitions("2", 2, 0.12, createNextLevelDependecy(10, 8)));
        list.add(new LevelDefinitions("3", 2, 0.03, createNextLevelDependecy(15, 12)));
        return list;
    }

    private List<NextLevelDependency> createNextLevelDependecy(Integer quantityOne, Integer quantityTwo) {
        List<NextLevelDependency> list = new ArrayList<>();
        list.add(new NextLevelDependency("metal", quantityOne));
        list.add(new NextLevelDependency("cristal", quantityTwo));
        return list;
    }

    public Resources(String type, String level, Double productionInterval, Integer quantityPerSecond, List<LevelDefinitions> levelDefinitions) {
        this.type = type;
        this.level = level;
        this.productionInterval = productionInterval;
        this.quantityPerSecond = quantityPerSecond;
        this.levelDefinitions = levelDefinitions;
    }
}
