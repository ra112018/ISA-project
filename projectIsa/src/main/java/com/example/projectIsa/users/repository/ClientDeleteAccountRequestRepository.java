package com.example.projectIsa.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectIsa.users.model.DeleteAccountRequest;

public interface ClientDeleteAccountRequestRepository extends JpaRepository<DeleteAccountRequest, Integer>{

}
