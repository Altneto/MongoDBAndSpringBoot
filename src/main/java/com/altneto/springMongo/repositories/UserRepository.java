package com.altneto.springMongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.altneto.springMongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	

}
