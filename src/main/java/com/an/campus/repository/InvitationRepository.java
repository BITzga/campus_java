package com.an.campus.repository;

import com.an.campus.model.Invitation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface InvitationRepository extends MongoRepository<Invitation,String> {
    Page<Invitation> findByTag(String tag,Pageable pageable);
    Invitation findFirstByOwnerId(String ownerId);
    List<Invitation> findInvitationsByTagAndDeadlineBeforeOrderByDeadline(Date date, Pageable pageable);

    Optional<Invitation> findById(BigInteger i);

    //boolean findByOwnerId(String s);
}
