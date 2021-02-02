package com.an.campus.controller;

import com.an.campus.dto.PageResult;
import com.an.campus.dto.QResult;
import com.an.campus.model.Comment;
import com.an.campus.model.Topic;
import com.an.campus.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;


@RestController
public class TopicController {

    @Autowired
    TopicService topicService;
    @GetMapping("/topics")
    public PageResult<List<Topic>> getTopicList(@RequestParam(defaultValue = "0") Integer currentPage){

        return topicService.getTopics(currentPage);
    }

    @GetMapping("/topic/{id}")
    public QResult<Topic> getTopicDetail(@PathVariable BigInteger id){
        Optional<Topic> topic = topicService.getTopic(id);
        if(topic.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
        }else{
            return topic.get();
        }
    }
    @GetMapping("/topic/{id}/comments")
    public PageResult<List<Comment>> getTopicComments(@PathVariable BigInteger id){

        return null;
    }
    @PostMapping("/topic/edit")
    public QResult<Topic> postTopic(){

        return null;
    }
    @PostMapping("/topic/{id}/like")
    public QResult<Topic> likeTopic(@PathVariable BigInteger id){



    }
    @PostMapping("/topic/{id}/unlike")
    public QResult<Topic> unlikeTopic(@PathVariable BigInteger id){



    }
}
