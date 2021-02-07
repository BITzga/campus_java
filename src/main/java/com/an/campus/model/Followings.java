package com.an.campus.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Document
public class Followings {
    @Id
    private BigInteger userId;
    List<BigInteger> followings;

    public Followings addInvite(BigInteger userId){
        if(followings==null)
            followings = new ArrayList<>();
        followings.add(userId);
        return this;
    }
    public Followings removeInvite(BigInteger userId){
        if(followings==null)
            return this;
        followings.remove(userId);
        return this;
    }
    public Followings(BigInteger userId, List<BigInteger> followings) {
        this.userId = userId;
        this.followings = followings;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public List<BigInteger> getFollowings() {
        return followings;
    }

    public void setFollowings(List<BigInteger> followings) {
        this.followings = followings;
    }
}
