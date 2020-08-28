package com.marcomenezes.mongoDBspringapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.marcomenezes.mongoDBspringapi.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
