package com.an.campus.repository;

import com.an.campus.model.Followings;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface FollowingRepository extends MongoRepository<Followings, BigInteger> {
     Optional<Followings> findById( BigInteger id);
}
