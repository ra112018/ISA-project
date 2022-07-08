package com.example.projectIsa.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectIsa.users.model.PasswordToken;

public interface PasswordTokenRepository extends JpaRepository<PasswordToken,Long>{

	PasswordToken findOneByEmail(String email);
	
	PasswordToken findOneByToken(String email);
}
