package com.an.campus.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigInteger;
import java.util.*;

@Document
public class Invitation {
    @Null
    @Id
    private BigInteger id;
    @NotNull
    private BigInteger ownerId;
    @NotNull
    private String ownerName;
    @NotNull
    private  String headImg;
    @NotNull
    private List<String> imgUrl;
    @NotNull
    private String tag;
    @Null
    private List<Comment> comments;
    @NotNull
    private String title;
    @NotNull
    private String context;
    @Null
    private Integer views;
    @Null
    private Integer likes;
    @Null
    private List<BigInteger> likeList;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sendDate;
    @NotNull
    @Valid
    private Activity activity;


    public synchronized Invitation like(BigInteger userId){
        if(likes==null)
            likes=0;
        if(likeList==null)
            likeList = new ArrayList<>();
        likeList.add(userId);
        likes++;
        return this;
    }
    public synchronized Invitation unlike(BigInteger userId){
        if(likes==null)
            likes=0;
        if(likeList==null)
            likeList = new ArrayList<>();
        likeList.remove(userId);
        likes--;
        return this;
    }
    public synchronized Invitation minusFollower(User user){
        if(activity.followCount==null)
            activity.followCount=0;
        if(activity.followers==null)
            activity.followers = new ArrayList<>();
        activity.followers.remove(user);
        activity.followCount--;
        return this;
    }
    public synchronized Invitation addFollower(User user){
        if(activity.followCount==null)
            activity.followCount=0;
        if(activity.followers==null)
            activity.followers = new ArrayList<>();
        activity.followers.add(user);
        activity.followCount++;
        return this;
    }
    public synchronized boolean commentIsEmpty(BigInteger commentId){
        for (int i=0;i< comments.size();i++){
            if(comments.get(i).getCommentId()==commentId){
                return false;
            }
        }
        return true;
    }
    public synchronized Invitation addComment(Comment comment){
        if(comments==null)
            comments = new ArrayList<>();
        this.comments.add(comment);
        return this;
    }
    public synchronized Invitation addSubComment(BigInteger commentId,Comment newComment){
        if(comments==null)
            comments = new ArrayList<>();
        for (int i=0;i< comments.size();i++){
            if(comments.get(i).getCommentId()==commentId){
                comments.get(i).addComment(newComment);
            }
        }
        return this;
    }


    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<BigInteger> getLikeList() {
        return likeList;
    }

    public void setLikeList(List<BigInteger> likeList) {
        this.likeList = likeList;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(BigInteger ownerId) {
        this.ownerId = ownerId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }


    public List<String> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(List<String> imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
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

}
