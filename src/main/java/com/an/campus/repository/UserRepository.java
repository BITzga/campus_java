package com.an.campus.repository;

import com.an.campus.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {


}
