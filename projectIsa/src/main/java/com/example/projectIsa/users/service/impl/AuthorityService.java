package com.example.projectIsa.users.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.users.model.Authority;
import com.example.projectIsa.users.repository.AuthorityRepository;
import com.example.projectIsa.users.service.IAuthorityService;

@Service
public class AuthorityService implements IAuthorityService{

	private AuthorityRepository authorityRepository;
	
	@Autowired
    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }
	
	@Override
    public List<Authority> findByName(String name) {
        Authority auth = this.authorityRepository.findByName(name);
        List<Authority> auths = new ArrayList<>();
        auths.add(auth);
        return auths;
    }
}
