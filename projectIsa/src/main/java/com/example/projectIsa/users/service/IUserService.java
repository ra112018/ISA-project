package com.example.projectIsa.users.service;

import com.example.projectIsa.users.dto.AccessTokenDTO;
import com.example.projectIsa.users.dto.UserLoginDTO;

public interface IUserService {
	//User loginUser(UserLoginDTO userLoginDto);
	Boolean checkUniqueUsername(String email);

	AccessTokenDTO login(UserLoginDTO userLoginDTO);

}
