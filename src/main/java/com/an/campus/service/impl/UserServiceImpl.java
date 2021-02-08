package com.an.campus.service.impl;

import com.an.campus.constants.StateEnum;
import com.an.campus.dto.PageResult;
import com.an.campus.dto.QResult;
import com.an.campus.model.Followings;
import com.an.campus.model.Invitation;
import com.an.campus.model.Topic;
import com.an.campus.model.User;
import com.an.campus.repository.FollowingRepository;
import com.an.campus.repository.InvitationRepository;
import com.an.campus.repository.TopicRepository;
import com.an.campus.repository.UserRepository;
import com.an.campus.service.UserService;
import com.an.campus.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.print.DocFlavor;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static BigInteger USER_ID=BigInteger.valueOf(100000);
    @Autowired
    UserRepository userRepository;
    @Autowired
    InvitationRepository invitationRepository;
    @Autowired
    TopicRepository topicRepository;
    @Autowired
    FollowingRepository followingRepository;

    @Autowired
    JwtUtils jwtUtils;
    private synchronized BigInteger getNewID(){
        USER_ID=USER_ID.add(BigInteger.valueOf(1));
        return USER_ID;
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
        System.out.println(getNewID());
        User newUser = userRepository.save(user.setDefaultId(getNewID()));
        if(newUser==null)
            return new QResult<User>(null, StateEnum.ERROR.getState());
        else {
            return new QResult<User>(newUser, StateEnum.SUCCESS.getState());
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

    @Override
    public PageResult<Page<Invitation>> getJoinedInvitations(BigInteger userId, Pageable pageable) {
        Optional<Followings> followings = followingRepository.findById(userId);
        if(followings.isEmpty())
            return new PageResult<>(new PageImpl<>(new ArrayList<Invitation>(),pageable,0), StateEnum.ERROR.getState(),pageable);
        else {
            List<Invitation> invitations = new ArrayList<>();
            for(var inviteID:followings.get().getFollowings()){
                invitations.add(invitationRepository.findById(inviteID).get());
            }
            Page<Invitation> page = new PageImpl<>(invitations,pageable,invitations.size());
            return new PageResult<>(page,StateEnum.SUCCESS.getState(), pageable);
        }
    }

    @Override
    public QResult<Object> login(BigInteger userId,String psw) {

        if(userRepository.findById(userId).get().getPwd().equals(psw))
            return new QResult<>(jwtUtils.generateToken(userId),StateEnum.SUCCESS.getState());
        return new QResult<>(null,StateEnum.ERROR.getState());

    }
}
