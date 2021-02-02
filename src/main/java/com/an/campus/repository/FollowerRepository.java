package com.an.campus.repository;

import com.an.campus.model.Followers;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FollowerRepository extends MongoRepository<Followers,String> {
     Optional<Followers> findById(String id);
}
