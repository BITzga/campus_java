package com.an.campus.service;

import com.an.campus.dto.PageResult;
import com.an.campus.dto.QResult;
import com.an.campus.model.Comment;
import com.an.campus.model.Invitation;
import com.an.campus.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;

public interface InvitationService {
    public PageResult<Page<Invitation>> getPages(String tag, Pageable pageable);
    public QResult<Invitation> getDetail(BigInteger id);
    public QResult<Invitation> create(Invitation invitation);
    public QResult<Invitation> like(BigInteger id, User user);
    public QResult<Invitation> unlike(BigInteger id, User user);
    public QResult<Invitation> join(BigInteger id, User user);
    public QResult<Invitation> disjoint(BigInteger id, User user);
    public QResult<Comment> comment(BigInteger id,Comment comment);
    public QResult<Comment> subComment(BigInteger id,BigInteger commendId,Comment comment);
}
