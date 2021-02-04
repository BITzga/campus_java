package com.an.campus.service.impl;

import com.an.campus.constants.StateEnum;
import com.an.campus.dto.PageResult;
import com.an.campus.dto.QResult;
import com.an.campus.model.Invitation;
import com.an.campus.model.Topic;
import com.an.campus.model.User;
import com.an.campus.repository.InvitationRepository;
import com.an.campus.repository.TopicRepository;
import com.an.campus.repository.UserRepository;
import com.an.campus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.print.DocFlavor;
import java.math.BigInteger;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static BigInteger ID=BigInteger.valueOf(10000);
    @Autowired
    UserRepository userRepository;
    @Autowired
    InvitationRepository invitationRepository;
    @Autowired
    TopicRepository topicRepository;

    private synchronized BigInteger getNewID(){
        ID.add(BigInteger.valueOf(1));
        return ID;
    }
    @Override
    public QResult<User> getUserInfo(BigInteger id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            return new QResult<User>(null, StateEnum.ERROR.getState());
        else {
            return new QResult<User>(user.get(), StateEnum.SUCCESS.getState());
        }
    }

    @Override
    public synchronized QResult<User> createUser(User user) {
        Optional<User> newUser = userRepository.save(user.setDefaultId(getNewID()));
        if(newUser.isEmpty())
            return new QResult<User>(null, StateEnum.ERROR.getState());
        else {
            return new QResult<User>(newUser.get(), StateEnum.SUCCESS.getState());
        }
    }

    @Override
    public PageResult<Page<Topic>> getTopics(BigInteger userId,  Pageable pageable) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty())
            return new PageResult<>(null, StateEnum.ERROR.getState(),pageable);
        else {

            return new PageResult<>(topicRepository.findByOwnerId(userId,pageable),StateEnum.SUCCESS.getState(), pageable);
        }
    }

    @Override
    public PageResult<Page<Invitation>> getInvitations(BigInteger userId,  Pageable pageable) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty())
            return new PageResult<>(null, StateEnum.ERROR.getState(),pageable);
        else {

            return new PageResult<>(invitationRepository.findByOwnerId(userId,pageable),StateEnum.SUCCESS.getState(), pageable);
        }
    }
}
