package com.an.campus.service;

import com.an.campus.dto.PageResult;
import com.an.campus.model.Comment;
import com.an.campus.model.Topic;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface TopicService {
    boolean comment(BigInteger topicId,Comment newComment);
    boolean comment(BigInteger topicId,BigInteger commentId,Comment newComment);
    boolean unlikeTopic(BigInteger id,BigInteger userId);
    boolean likeTopic(BigInteger id,BigInteger userId);
    boolean createTopic(Topic topic);
    PageResult<List<Comment>> getComments(BigInteger topicId);
    PageResult<List<Topic>> getTopics(Integer currentPage);
    Optional<Topic> getTopic(BigInteger id);
}
