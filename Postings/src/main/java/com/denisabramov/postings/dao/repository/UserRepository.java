package com.denisabramov.postings.dao.repository;

import com.denisabramov.postings.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
