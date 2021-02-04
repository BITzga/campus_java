package com.an.campus.controller;

import com.an.campus.dto.PageResult;
import com.an.campus.dto.QResult;
import com.an.campus.model.Invitation;
import com.an.campus.model.Topic;
import com.an.campus.model.User;
import com.an.campus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@CrossOrigin
@RequestMapping(produces = "application/json")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/{id}") //获取用户基本信息
    public QResult<User> getUser(@PathVariable BigInteger id){

        return userService.getUserInfo(id);
    }
    @PostMapping("/user")//创建用户
    public QResult<User> creatUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping("/me/{id}/topics") //获取用户发过的帖子、邀请、加入过的邀请
    public PageResult<Page<Topic>> getTopics(@PathVariable BigInteger id, @RequestBody Pageable pageable){
        return userService.getTopics(id,pageable);
    }
    @GetMapping("/me/{id}/invites")
    public PageResult<Page<Invitation>> getInvites(@PathVariable BigInteger id, @RequestBody Pageable pageable){
        return userService.getInvitations(id,pageable);
    }
    /*
    @GetMapping("/following")//获取关注的人
    @GetMapping("/followers")//获取粉丝

    @PostMapping("/follow/{id}")//关注某人
    @DeleteMapping("/follow/{id}")//*/

}
