package com.example.projectIsa.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectIsa.users.model.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Integer>{

	Authority findByName(String name);
}
