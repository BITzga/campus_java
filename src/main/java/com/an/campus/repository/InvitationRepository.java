package com.an.campus.repository;

import com.an.campus.model.Invitation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface InvitationRepository extends MongoRepository<Invitation,String> {
    Invitation findFirstByOwnerId(String ownerId);
    List<Invitation> findInvitationsByTagAndDeadlineBeforeOrderByDeadline(Date date, Pageable pageable);

    Invitation findById(BigInteger i);

    //boolean findByOwnerId(String s);
}
