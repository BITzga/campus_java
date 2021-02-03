package com.an.campus.service;

import com.an.campus.dto.PageResult;
import com.an.campus.dto.QResult;
import com.an.campus.model.Invitation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;

public interface InvitationService {
    public PageResult<Page<Invitation>> getPages(String tag, Pageable pageable);
    public QResult<Invitation> getDetail(BigInteger id);
    public QResult<Invitation> create(Invitation invitation);
}
