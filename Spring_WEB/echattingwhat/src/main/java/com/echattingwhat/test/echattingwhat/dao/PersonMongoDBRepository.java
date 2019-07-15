package com.echattingwhat.test.echattingwhat.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.echattingwhat.test.echattingwhat.entity.Person;

public interface PersonMongoDBRepository extends MongoRepository<Person, String> {
	public Person findByName(String name);

}
