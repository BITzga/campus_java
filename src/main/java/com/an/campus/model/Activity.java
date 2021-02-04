package com.an.campus.model;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class Activity {
    String Tag;
    Date deadline;
    Date start;
    Date end;
    Invitation followCount;
    private List<User> followers;
    private String position;

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Invitation getFollowCount() {
        return followCount;
    }

    public void setFollowCount(Invitation followCount) {
        this.followCount = followCount;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
