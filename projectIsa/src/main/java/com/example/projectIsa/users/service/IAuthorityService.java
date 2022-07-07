package com.example.projectIsa.users.service;

import java.util.List;

import com.example.projectIsa.users.model.Authority;

public interface IAuthorityService {

	List<Authority> findByName(String name);
}
