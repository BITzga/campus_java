package com.an.campus.service;

import com.an.campus.model.Topic;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface TopicService {
    List<Topic> getTopics(Integer currentPage);
    Optional<Topic> getTopic(BigInteger id);
}
