package com.qa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.qa.domain.Cv;

public interface ICvRepository extends MongoRepository<Cv, String> {

    Cv findByName(String name);
}
