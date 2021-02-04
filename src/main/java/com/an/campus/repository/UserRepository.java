package com.an.campus.repository;

import com.an.campus.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User,BigInteger> {
    Optional<User> findById(User user);
    User save(User user);


}
