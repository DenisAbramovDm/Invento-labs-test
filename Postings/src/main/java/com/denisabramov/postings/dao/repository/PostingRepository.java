package com.denisabramov.postings.dao.repository;

import com.denisabramov.postings.dao.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostingRepository extends JpaRepository<Posting, Long> {
    List<Posting> findAllByIsAuthorized(boolean isAuthorized);
}
