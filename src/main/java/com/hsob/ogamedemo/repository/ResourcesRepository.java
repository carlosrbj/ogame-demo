package com.hsob.ogamedemo.repository;

import com.hsob.ogamedemo.model.resources.Resources;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourcesRepository extends MongoRepository<Resources, String> {
}
