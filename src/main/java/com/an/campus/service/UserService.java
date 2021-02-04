package com.an.campus.service;

import com.an.campus.dto.PageResult;
import com.an.campus.dto.QResult;
import com.an.campus.model.Invitation;
import com.an.campus.model.Topic;
import com.an.campus.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;

public interface UserService {
    QResult<User> getUserInfo(BigInteger id);
    QResult<User> createUser(User user);
    PageResult<Page<Topic>> getTopics(BigInteger userId, Pageable pageable);
    PageResult<Page<Invitation>> getInvitations(BigInteger userId, Pageable pageable);

}
