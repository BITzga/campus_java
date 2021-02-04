package com.an.campus.service.impl;

import com.an.campus.constants.StateEnum;
import com.an.campus.dto.PageResult;
import com.an.campus.dto.QResult;
import com.an.campus.model.Comment;
import com.an.campus.model.Invitation;
import com.an.campus.model.User;
import com.an.campus.repository.InvitationRepository;
import com.an.campus.repository.UserRepository;
import com.an.campus.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class InvitationServiceImpl implements InvitationService {
    @Autowired
    InvitationRepository invitationRepository;
    @Autowired
    UserRepository userRepository;
    private static BigInteger ID=BigInteger.valueOf(10000);

    private synchronized BigInteger getNewID(){
        ID=ID.add(BigInteger.valueOf(1));
        return ID;
    }
    public PageResult<Page<Invitation> > getPages(String tag, Pageable pageable) {
        Page<Invitation> pages;

        if (tag.equals("all")) {
            pages = invitationRepository.findAll(pageable);

        } else {
            pages = invitationRepository.findByTag(tag, pageable);
        }
        if(pages.isEmpty()){
            return new PageResult<>(pages,StateEnum.ERROR.getState(), pageable);
        }else {
            return new PageResult<>(pages,StateEnum.SUCCESS.getState(), pageable);
        }
    }

    @Override
    public QResult<Invitation> getDetail(BigInteger id) {
        Optional<Invitation> detail;
        detail = invitationRepository.findById(id);
        if(detail.isEmpty()){
            return new QResult<>(null,StateEnum.ERROR.getState());
        }else {

            return new QResult<>(detail.get(),StateEnum.SUCCESS.getState());
        }
    }

    @Override
    public QResult<Invitation> create(Invitation invitation) {
        invitation.setId(getNewID());
        Invitation detail;
        detail = invitationRepository.save(invitation);
        if(detail==null)
            return new QResult<>(null,StateEnum.ERROR.getState());
        else{
            return new QResult<>(detail,StateEnum.SUCCESS.getState());
        }
    }

    @Override
    public QResult<Invitation> like(BigInteger id, User user) {
        Optional<Invitation> invitation = invitationRepository.findById(id);
        if (invitation.isEmpty()) {

            return new QResult<Invitation>(null, StateEnum.ERROR.getState());
        } else {
            invitationRepository.save(invitation.get().like(user.getId()));
            return new QResult<Invitation>(invitation.get(), StateEnum.SUCCESS.getState());
        }
    }

    @Override
    public QResult<Invitation> unlike(BigInteger id, User user) {
        Optional<Invitation> invitation = invitationRepository.findById(id);
        if (invitation.isEmpty()) {

            return new QResult<Invitation>(null, StateEnum.ERROR.getState());
        } else {
            invitationRepository.save(invitation.get().unlike(user.getId()));
            return new QResult<Invitation>(invitation.get(), StateEnum.SUCCESS.getState());
        }
    }

    @Override
    public QResult<Invitation> join(BigInteger id, User user) {
        Optional<Invitation> invitation = invitationRepository.findById(id);
        if (invitation.isEmpty()) {

            return new QResult<Invitation>(null, StateEnum.ERROR.getState());
        } else {
            invitationRepository.save(invitation.get().addFollower(user));
            return new QResult<Invitation>(invitation.get(), StateEnum.SUCCESS.getState());
        }
    }

    @Override
    public QResult<Invitation> disjoint(BigInteger id, User user) {
        Optional<Invitation> invitation = invitationRepository.findById(id);
        if (invitation.isEmpty()) {

            return new QResult<Invitation>(null, StateEnum.ERROR.getState());
        } else {
            invitationRepository.save(invitation.get().minusFollower(user));
            return new QResult<Invitation>(invitation.get(), StateEnum.SUCCESS.getState());
        }
    }

    @Override
    public QResult<Comment> comment(BigInteger id,Comment comment) {

        Optional<Invitation> detail = invitationRepository.findById(id);
        if(detail.isEmpty()){
            return new QResult<>(comment,StateEnum.ERROR.getState());
        }else {
            invitationRepository.save(detail.get().addComment(comment));
            return new QResult<>(comment,StateEnum.SUCCESS.getState());
        }
    }

    @Override
    public QResult<Comment> subComment(BigInteger id, BigInteger commendId, Comment comment) {
        Optional<Invitation> detail = invitationRepository.findById(id);
        if(detail.isEmpty()||detail.get().commentIsEmpty(commendId))
            return new QResult<>(comment,StateEnum.ERROR.getState());
        else {
            invitationRepository.save(detail.get().addSubComment(commendId,comment));
            return new QResult<>(comment,StateEnum.SUCCESS.getState());
        }
    }
}