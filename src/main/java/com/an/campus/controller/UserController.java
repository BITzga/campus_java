package com.an.campus.controller;

import com.an.campus.constants.StateEnum;
import com.an.campus.dto.PageResult;
import com.an.campus.dto.QResult;
import com.an.campus.model.Invitation;
import com.an.campus.model.Topic;
import com.an.campus.model.User;
import com.an.campus.repository.UserRepository;
import com.an.campus.service.UserService;
import com.an.campus.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.EnumSet;

@RestController
@CrossOrigin
@RequestMapping(produces = "application/json")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserRepository userRepository;
    private static BigInteger ID=BigInteger.valueOf(200000);

    private synchronized BigInteger getNewID(){
        ID=ID.add(BigInteger.valueOf(1));
        return ID;
    }
    @GetMapping("/user/{id}") //获取用户基本信息
    public QResult<User> getUser(@PathVariable BigInteger id){

        return userService.getUserInfo(id);
    }
    @PostMapping("/user")//创建用户
    public QResult<User> creatUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping("/me/{id}/topics") //获取用户发过的帖子、邀请、加入过的邀请
    public PageResult<Page<Topic>> getTopics(@PathVariable BigInteger id,  Pageable pageable){
        return userService.getTopics(id,pageable);
    }
    @GetMapping("/me/{id}/invites")
    public PageResult<Page<Invitation>> getInvites(@PathVariable BigInteger id,  Pageable pageable){
        return userService.getInvitations(id,pageable);
    }
    @GetMapping("/me/{id}/joined")
    public PageResult<Page<Invitation>> getJoinedInvites(@PathVariable BigInteger id,Pageable pageable){

        return  userService.getJoinedInvitations(id,pageable);

    }
    @PostMapping("/login")
    public QResult<Object> login( @RequestBody @Validated User user){

        System.out.println(user);
        return userService.login(user.getId(),user.getPwd());


    }

    @PostMapping("/sign")
    public QResult<Object> sign(@RequestBody @Validated User user){
        user.setId(getNewID());
        return new QResult<>(userRepository.save(user), StateEnum.SUCCESS.getState());
    }

    /*
    @GetMapping("/following")//获取关注的人
    @GetMapping("/followers")//获取粉丝

    @PostMapping("/follow/{id}")//关注某人
    @DeleteMapping("/follow/{id}")//*/

}
