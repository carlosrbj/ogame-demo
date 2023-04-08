package com.hsob.ogamedemo.repository;

import com.hsob.ogamedemo.model.resources.Resources;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourcesRepository extends MongoRepository<Resources, String> {
    List<Resources> findByUserId(String userId);
}
