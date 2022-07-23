package com.example.projectIsa.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectIsa.users.model.ComplaintReply;

@Repository
public interface ComplaintReplyRepository extends JpaRepository<ComplaintReply, Integer>{

}
