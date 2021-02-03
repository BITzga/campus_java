package com.an.campus.controller;

import com.an.campus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = "application/json")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/{id}") //获取用户基本信息
    @GetMapping("/me/{id}") //获取用户发过的帖子、邀请、加入过的邀请
    @GetMapping("/following")//获取关注的人
    @GetMapping("/followers")//获取粉丝
    @PostMapping("/user")//创建用户
    @PostMapping("/follow/{id}")//关注某人
    @DeleteMapping("/follow/{id}")//取消关注某人

}
