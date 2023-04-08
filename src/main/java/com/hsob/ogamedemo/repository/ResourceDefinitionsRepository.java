package com.hsob.ogamedemo.repository;

import com.hsob.ogamedemo.model.resources_definitions.ResourceDefinitions;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ResourceDefinitionsRepository extends MongoRepository<ResourceDefinitions, String> {
    List<ResourceDefinitions> findAllByType(String type);
}
