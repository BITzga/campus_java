package com.an.campus.repository;

import com.an.campus.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.Optional;


public interface TopicRepository extends MongoRepository<Topic,String> {
    Page<Topic> findAll(Pageable page);
    Optional<Topic> findById(BigInteger id);
}
