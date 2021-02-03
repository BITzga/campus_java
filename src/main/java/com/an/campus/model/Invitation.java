package com.an.campus.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document
public class Invitation {
    @Id
    private BigInteger id;
    private String ownerId;
    private String tag;
    private List<String> imgUrl;
    private List<Comment> comments;
    private String title;
    private String context;
    private Integer views;
    private Integer likes;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sendDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deadline;
    private Integer followCount;
    private List<User> followers;
    private String position;

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
