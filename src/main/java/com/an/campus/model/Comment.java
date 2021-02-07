package com.an.campus.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Comment {
    private BigInteger commentId;
    private BigInteger belongId;
    @NotNull
    private BigInteger replyToId;
    private String replyToName;
    private String replyToHead;
    @NotNull
    private BigInteger userId;
    private String username;
    @NotNull
    private String context;
    private String headImg;
    private Integer likes=0;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sendDate;
    private List<Comment> subComments;

    public Comment(BigInteger commentId, BigInteger belongId, BigInteger replyToId, BigInteger userId, String context, String headImg, Integer likes, Date sendDate, List<Comment> subComments) {
        this.commentId = commentId;
        this.belongId = belongId;
        this.replyToId = replyToId;
        this.userId = userId;
        this.context = context;
        this.headImg = headImg;
        this.likes = likes;
        this.sendDate = sendDate;
        this.subComments = subComments;
    }


    public String getReplyToName() {
        return replyToName;
    }

    public void setReplyToName(String replyToName) {
        this.replyToName = replyToName;
    }

    public String getReplyToHead() {
        return replyToHead;
    }

    public void setReplyToHead(String replyToHead) {
        this.replyToHead = replyToHead;
    }

    public synchronized void addComment(Comment comment){
        if(this.subComments==null)
            this.subComments=new ArrayList<>();
        this.subComments.add(comment);
    }
    public BigInteger getCommentId() {
        return commentId;
    }

    public void setCommentId(BigInteger commentId) {
        this.commentId = commentId;
    }

    public BigInteger getBelongId() {
        return belongId;
    }

    public void setBelongId(BigInteger belongId) {
        this.belongId = belongId;
    }

    public BigInteger getReplyToId() {
        return replyToId;
    }

    public void setReplyToId(BigInteger replyToId) {
        this.replyToId = replyToId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public List<Comment> getSubComments() {
        return subComments;
    }

    public void setSubComments(List<Comment> subComments) {
        this.subComments = subComments;
    }
}
