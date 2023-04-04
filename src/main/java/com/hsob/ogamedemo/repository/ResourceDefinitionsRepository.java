package com.hsob.ogamedemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResourceDefinitionsRepository extends MongoRepository<com.hsob.ogamedemo.model.resources_definitions.ResourceDefinitions, String> {
}
