package com.an.campus.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigInteger;
import java.util.*;


@Document
public class Topic {
    @Null
    @Id
    private BigInteger id;
    @NotNull
    private BigInteger ownerId;
    @Null
    private String username;
    @Null
    private String headImg;
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
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sendDate;
    @Null
    private List<BigInteger> likeList;

    public Topic(BigInteger id, BigInteger ownerId, List<String> imgUrl, List<Comment> comments, String title, String context, Integer views, Integer likes, Date sendDate, List<BigInteger> likeList) {
        this.id = id;
        this.ownerId = ownerId;
        this.imgUrl = imgUrl;
        this.comments = comments;
        this.title = title;
        this.context = context;
        this.views = views;
        this.likes = likes;
        this.sendDate = sendDate;
        this.likeList = likeList;
    }

    public void addComment(Comment comment){
        synchronized (this) {
            if(comments==null)
                comments = new ArrayList<>();
            this.comments.add(comment);
        }
    }
    public void addComment(BigInteger commentId,Comment newComment){
        synchronized (this) {
            if(comments==null)
                comments = new ArrayList<>();
            for (var comment : comments) {
                if (comment.getCommentId() == commentId) {
                    comment.addComment(newComment);
                }
            }
        }
    }
    public void removeLike(BigInteger userId){
        synchronized (this){
            if(likes==null)
                likes=0;
            this.likes--;
            if(likeList==null)
                likeList = new ArrayList<>();
            this.likeList.remove(userId);
        }
    }
    public void addLike(BigInteger userId){
        synchronized (this) {
            if(likes==null)
                likes=0;
            this.likes++;
            if(likeList==null)
                likeList = new ArrayList<>();
            this.likeList.add(userId);
        }
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

//    public Topic(BigInteger id, String context) {
//        this.id = id;
//        this.context = context;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return id.equals(topic.id) && Objects.equals(ownerId, topic.ownerId) && Objects.equals(imgUrl, topic.imgUrl) && Objects.equals(comments, topic.comments) && Objects.equals(context, topic.context) && Objects.equals(views, topic.views) && Objects.equals(likes, topic.likes) && Objects.equals(sendDate, topic.sendDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ownerId, imgUrl, comments, context, views, likes, sendDate);
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", ownerId='" + ownerId + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", comments=" + comments +
                ", context='" + context + '\'' +
                ", views=" + views +
                ", likes=" + likes +
                ", sendDate=" + sendDate +
                '}';
    }
}
