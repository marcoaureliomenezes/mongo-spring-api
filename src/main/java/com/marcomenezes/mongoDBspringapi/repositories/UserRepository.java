package com.marcomenezes.mongoDBspringapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.marcomenezes.mongoDBspringapi.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
