package com.an.campus.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

@Document
public class User {

    @Id
    private BigInteger id;
    @NotNull
    private String username;
    @NotNull
    private String pwd;
    private String gender;
    private String email;
    private String headImgUrl;

    public User(BigInteger id, @NotNull String username, @NotNull String pwd, String gender, String email, String headImgUrl) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.gender = gender;
        this.email = email;
        this.headImgUrl = headImgUrl;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && Objects.equals(username, user.username) && Objects.equals(pwd, user.pwd) && Objects.equals(gender, user.gender) && Objects.equals(email, user.email) && Objects.equals(headImgUrl, user.headImgUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, pwd, gender, email, headImgUrl);
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public User setDefaultId(BigInteger id){
        this.id = id;
        return this;
    }




    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
