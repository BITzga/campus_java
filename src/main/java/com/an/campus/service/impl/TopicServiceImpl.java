package com.an.campus.service.impl;

import com.an.campus.model.Topic;
import com.an.campus.repository.TopicRepository;
import com.an.campus.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicRepository topicRepository;


    @Override
    public List<Topic> getTopics(Integer currentPage) {
        Pageable page = PageRequest.of(currentPage,10);
        Page<Topic> pages =topicRepository.findAll(page);
        List<Topic> topics = pages.toList();
        return topics;
    }

    @Override
    public Optional<Topic> getTopic(BigInteger id) {
        return topicRepository.findById(id);
    }
}
