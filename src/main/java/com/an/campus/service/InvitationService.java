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
    PageResult<Page<Invitation>> getPages(String tag, Pageable pageable);
    QResult<Invitation> getDetail(BigInteger id);
    QResult<Invitation> create(Invitation invitation);
    QResult<Invitation> like(BigInteger id,BigInteger userId);
    QResult<Invitation> unlike(BigInteger id, BigInteger userId);
    QResult<Invitation> join(BigInteger id, BigInteger userId);
    QResult<Invitation> disjoint(BigInteger id, BigInteger userId);
    QResult<Comment> comment(BigInteger id, Comment comment);
    QResult<Comment> subComment(BigInteger id, BigInteger commendId, Comment comment);
}
