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

}
