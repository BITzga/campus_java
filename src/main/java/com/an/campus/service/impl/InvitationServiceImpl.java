package com.an.campus.service.impl;

import com.an.campus.constants.StateEnum;
import com.an.campus.dto.PageResult;
import com.an.campus.dto.QResult;
import com.an.campus.model.Invitation;
import com.an.campus.repository.InvitationRepository;
import com.an.campus.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class InvitationServiceImpl implements InvitationService {
    @Autowired
    InvitationRepository invitationRepository;

    public PageResult<Page<Invitation> > getPages(String tag, Pageable pageable) {
        Page<Invitation> pages;

        if (tag == "all") {
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
        Invitation detail;
        detail = invitationRepository.save(invitation);
        if(detail==null)
            return new QResult<>(null,StateEnum.ERROR.getState());
        else{
            return new QResult<>(detail,StateEnum.SUCCESS.getState());
        }
    }
}