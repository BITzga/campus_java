package com.an.campus.controller;

import com.an.campus.constants.StateEnum;
import com.an.campus.dto.PageResult;
import com.an.campus.dto.QResult;
import com.an.campus.model.Comment;
import com.an.campus.model.Topic;
import com.an.campus.model.User;
import com.an.campus.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping(produces = "application/json")
public class TopicController {

    @Autowired
    TopicService topicService;
    @GetMapping("/topics")
    public PageResult<Page<Topic>> getTopicList(Pageable pageable){

        return topicService.getTopics(pageable);
    }

    @GetMapping("/topic/{id}")
    public QResult<Topic> getTopicDetail(@PathVariable BigInteger id){
        Optional<Topic> topic = topicService.getTopic(id);
        if(topic.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
        }else{
             QResult<Topic> qResult = new QResult<>(topic.get(), StateEnum.SUCCESS.getState());
             return qResult;
        }
    }
//    @GetMapping("/topic/{id}/comments")
//    public PageResult<List<Comment>> getTopicComments(@PathVariable BigInteger id){
//
//        return topicService.getComments(id);
//    }
    @PostMapping("/topic")
    public QResult<Topic> postTopic(@RequestBody @Validated Topic topic){
        if(topicService.createTopic(topic))
            return new QResult<>(null,StateEnum.SUCCESS.getState());
        else{
            return new QResult<>(null,StateEnum.ERROR.getState());
        }
    }
    @PostMapping("/topic/{id}/like")
    public QResult<Topic> likeTopic(@PathVariable BigInteger id, @RequestBody User user){

        if(topicService.likeTopic(id,user.getId()))
            return new QResult<Topic>(null,StateEnum.SUCCESS.getState());
        else{
            return new QResult<Topic>(null,StateEnum.ERROR.getState());
        }

    }
    @PostMapping("/topic/{id}/unlike")
    public QResult<Topic> unlikeTopic(@PathVariable BigInteger id, @RequestBody User user){

        if(topicService.unlikeTopic(id,user.getId()))
            return new QResult<Topic>(null,StateEnum.SUCCESS.getState());
        else{
            return new QResult<Topic>(null,StateEnum.ERROR.getState());
        }
    }

    @PostMapping("/topic/{id}/comment")
    public QResult<Topic> comment(@PathVariable BigInteger id,@RequestParam Comment newCommend){
        topicService.comment(id,newCommend);
        return new QResult<>(null,StateEnum.SUCCESS.getState());
    }
    @PostMapping("/topic/{id}/comment/{commandId}")
    public QResult<Topic> comment(@PathVariable BigInteger id,@PathVariable BigInteger commandId,@RequestParam Comment newCommend){
        topicService.comment(id,commandId,newCommend);
        return new QResult<>(null,StateEnum.SUCCESS.getState());
    }


}
