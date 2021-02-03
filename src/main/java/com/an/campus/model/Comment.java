package com.an.campus.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class Comment {
    private BigInteger commentId;
    private BigInteger belongId;
    private BigInteger replyToId;
    private String context;
    private String userId;
    private String headImg;
    private Integer likes;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sendDate;
    private List<Comment> subComments;
    public void addComment(Comment comment){
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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
