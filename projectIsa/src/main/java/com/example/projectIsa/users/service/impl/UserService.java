package com.example.projectIsa.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.users.repository.UserRepository;
import com.example.projectIsa.users.service.IUserService;

@Service
public class UserService implements IUserService{

	private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
