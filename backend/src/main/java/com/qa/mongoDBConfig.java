package com.qa;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.qa.repository.ICvRepository;

@EnableMongoRepositories(basePackageClasses = ICvRepository.class)
@Configuration
public class mongoDBConfig {

}
