package com.example.projectIsa.users.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.projectIsa.users.model.PasswordToken;
import com.example.projectIsa.users.repository.PasswordTokenRepository;

@Service
public class PasswordTokenService {

	private final PasswordTokenRepository passwordTokenRepository;
	
	public PasswordTokenService(PasswordTokenRepository passwordTokenRepository) {
		 this.passwordTokenRepository = passwordTokenRepository;
	}
	
	public PasswordToken createToken(String email){
	     PasswordToken passwordToken = new PasswordToken();
	     passwordToken.setEmail(email);
	     passwordToken.setExpiryDate(passwordToken.calculateExpiryDate(24*60));
	     passwordToken.setToken(UUID.randomUUID().toString());
	     return passwordTokenRepository.save(passwordToken);
	 }
}
