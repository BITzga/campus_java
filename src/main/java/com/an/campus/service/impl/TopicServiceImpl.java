package com.an.campus.service.impl;

import com.an.campus.constants.StateEnum;
import com.an.campus.dto.PageResult;
import com.an.campus.model.Comment;
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

    private static BigInteger ID=BigInteger.valueOf(10000);

    private synchronized BigInteger getNewID(){
        ID=ID.add(BigInteger.valueOf(1));
        return ID;
    }
    @Override
    public boolean comment(BigInteger topicId,Comment newComment) {
        Optional<Topic> topic = topicRepository.findById(topicId);
        if(topic.isEmpty())
            return false;
        else {
            topic.get().addComment(newComment);
            topicRepository.save(topic.get());
            return true;
        }
    }

    @Override
    public boolean comment(BigInteger topicId, BigInteger commentId,Comment newComment) {
        Optional<Topic> topic = topicRepository.findById(topicId);
        if(topic.isEmpty())
            return false;
        else {
            topic.get().addComment(commentId,newComment);
            topicRepository.save(topic.get());
            return true;
        }
    }

    @Override
    public boolean unlikeTopic(BigInteger id, BigInteger userId) {
        Optional<Topic> topic = topicRepository.findById(id);
        if(topic.isEmpty())
            return false;
        else {
            topic.get().removeLike(userId);
            topicRepository.save(topic.get());
            return true;
        }
    }

    @Override
    public boolean likeTopic(BigInteger id, BigInteger userId) {
        Optional<Topic> topic = topicRepository.findById(id);
        if(topic.isEmpty())
            return false;
        else {
            topic.get().addLike(userId);
            topicRepository.save(topic.get());
            return true;
        }
    }

    @Override
    public boolean createTopic(Topic topic) {
        topic.setId(getNewID());
        topicRepository.save(topic);
        System.out.println(topic);
        return true;
    }
//    @Override
//    public PageResult<List<Comment>> getComments(BigInteger topicId){
//
//        Optional<Topic> topic = topicRepository.findById(topicId);
//        if(topic.isEmpty()){
//            return new PageResult<List<Comment>>(null,StateEnum.ERROR.getState(), 10,0);
//        }else {
//            return new PageResult<List<Comment>>(topic.get().getComments(), StateEnum.SUCCESS.getState(), 10,1);
//        }
//    }

    @Override
    public PageResult<Page<Topic>> getTopics(Pageable pageable) {

        Page<Topic> pages =topicRepository.findAll(pageable);
        PageResult<Page<Topic>> pageResult = new PageResult<>(pages, StateEnum.SUCCESS.getState(), pageable);
        return pageResult;
    }

    @Override
    public Optional<Topic> getTopic(BigInteger id) {
        return topicRepository.findById(id);
    }
}
