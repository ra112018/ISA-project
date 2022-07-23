package com.example.projectIsa.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectIsa.users.model.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer>{

}
