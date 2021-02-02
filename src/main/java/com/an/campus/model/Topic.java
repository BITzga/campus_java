package com.an.campus.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Document
public class Topic {
    @Id
    private BigInteger id;
    private String ownerId;
    private List<String> imgUrl;
    private List<Comment> comments;
    private String title;
    private String context;
    private Integer views;
    private Integer likes;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sendDate;

    public Topic(BigInteger id, String ownerId, List<String> imgUrl, List<Comment> comments, String context, Integer views, Integer likes, Date sendDate) {
        this.id = id;
        this.ownerId = ownerId;
        this.imgUrl = imgUrl;
        this.comments = comments;
        this.context = context;
        this.views = views;
        this.likes = likes;
        this.sendDate = sendDate;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
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
