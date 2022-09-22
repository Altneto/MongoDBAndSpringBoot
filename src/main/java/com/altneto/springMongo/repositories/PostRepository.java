package com.altneto.springMongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.altneto.springMongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	

}
