package com.an.campus.controller;

import com.an.campus.dto.PageResult;
import com.an.campus.dto.QResult;
import com.an.campus.model.Comment;
import com.an.campus.model.Invitation;
import com.an.campus.model.User;
import com.an.campus.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(produces = "application/json")
public class InvitationController {
    @Autowired
    InvitationService invitationService;

    @GetMapping("/invitations")             //获取一定页数的邀请
    public PageResult<Page<Invitation>> getInvitations(@RequestParam @DefaultValue("all") String tag,
                                                       @PageableDefault(
                                                               page = 0,  //第几页
                                                               size = 10, //返回一页 共10条数据
                                                               sort = {"sendDate"},//发送时间排序
                                                               direction = Sort.Direction.DESC//降序
                                                       ) Pageable pageable){

        return  invitationService.getPages(tag,pageable);

    }
    @GetMapping("/invitation/{id}")         //获取邀请详情
    public QResult<Invitation>  getInvitation(@PathVariable BigInteger id){

        return invitationService.getDetail(id);

    }
    @PostMapping("/invitation")             //发起邀请
    public QResult<Invitation> createInvitation(@RequestBody @Validated Invitation invitation){
        
        return invitationService.create(invitation);
    }
    @PostMapping("/invitation/{id}/comment")//给邀请评论
    public QResult<Comment> comment(@PathVariable BigInteger id,@RequestBody @Validated Comment comment){
        return invitationService.comment(id,comment);
    }
    @PostMapping("/invitation/{id}/comment/{commandId}")//回复评论
    public QResult<Comment> subComment(@PathVariable BigInteger id,
                                       @PathVariable BigInteger commandId,
                                       @RequestBody @Validated Comment comment){
        return invitationService.subComment(id, commandId, comment);

    }
    @PostMapping("/invitation/{id}/like")    //点赞
    public QResult<Invitation> likeInvitation(@PathVariable BigInteger id, @RequestBody User user){
        return invitationService.like(id,user);
        
    }
    @DeleteMapping("/invitation/{id}/like")   //取消赞
    public QResult<Invitation> unlikeInvitation(@PathVariable BigInteger id, @RequestBody User user){

        return invitationService.unlike(id, user);
    }
    @PostMapping("/invitation/{id}/join")   //加入邀请
    public QResult<Invitation> joinInvitation(@PathVariable BigInteger id, @RequestBody User user){

        return invitationService.join(id,user);
    }
    @DeleteMapping("/invitation/{id}/join") //取消加入邀请
    public QResult<Invitation> disjointInvitation(@PathVariable BigInteger id, @RequestBody User user){

        return invitationService.disjoint(id,user);
    }

}
