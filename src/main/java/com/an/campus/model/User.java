package com.an.campus.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Objects;

@Document
public class User {
    @Id
    private BigInteger id;
    private String username;
    private String pwd;
    private String gender;
    private String email;
    private String headImgUrl;


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", headImg='" + headImg + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && Objects.equals(username, user.username) && Objects.equals(pwd, user.pwd) && Objects.equals(gender, user.gender) && Objects.equals(email, user.email) && Objects.equals(headImg, user.headImg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, pwd, gender, email, headImg);
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

    private String headImg;

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

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}
