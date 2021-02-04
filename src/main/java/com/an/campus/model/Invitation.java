package com.an.campus.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String tag;
    @NotNull
    private List<String> imgUrl;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deadline;
    @Null
    private Integer followCount;
    @Null
    private List<User> followers;
    @NotNull
    private String position;


    public synchronized Invitation like(BigInteger userId){
        likeList.add(userId);
        likes++;
        return this;
    }
    public synchronized Invitation unlike(BigInteger userId){
        likeList.remove(userId);
        likes--;
        return this;
    }
    public synchronized Invitation minusFollower(User user){
        followers.remove(user);
        followCount--;
        return this;
    }
    public synchronized Invitation addFollower(User user){

        followers.add(user);
        followCount++;
        return this;
    }
    public boolean commentIsEmpty(BigInteger commentId){
        for (var comment: comments){
            if(comment.getCommentId()==commentId){
                return false;
            }
        }
        return true;
    }
    public synchronized Invitation addComment(Comment comment){
        this.comments.add(comment);
        return this;
    }
    public synchronized Invitation addSubComment(BigInteger commentId,Comment newComment){
        for (var comment: comments){
            if(comment.getCommentId()==commentId){
                comment.addComment(newComment);
            }
        }
        return this;
    }

    @Override
    public String toString() {
        return "Invitation{" +
                "id=" + id +
                ", ownerId='" + ownerId + '\'' +
                ", tag='" + tag + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", comments=" + comments +
                ", context='" + context + '\'' +
                ", views=" + views +
                ", likes=" + likes +
                ", sendDate=" + sendDate +
                ", deadline=" + deadline +
                ", followCount=" + followCount +
                ", followers=" + followers +
                '}';
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invitation that = (Invitation) o;
        return id.equals(that.id) && Objects.equals(ownerId, that.ownerId) && Objects.equals(tag, that.tag) && Objects.equals(imgUrl, that.imgUrl) && Objects.equals(comments, that.comments) && Objects.equals(context, that.context) && Objects.equals(views, that.views) && Objects.equals(likes, that.likes) && Objects.equals(sendDate, that.sendDate) && Objects.equals(deadline, that.deadline) && Objects.equals(followCount, that.followCount) && Objects.equals(followers, that.followers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ownerId, tag, imgUrl, comments, context, views, likes, sendDate, deadline, followCount, followers);
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

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getFollowCount() {
        return followCount;
    }

    public void setFollowCount(Integer followCount) {
        this.followCount = followCount;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }
}
