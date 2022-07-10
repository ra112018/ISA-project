package com.example.projectIsa.users.controller;

import java.text.ParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.users.dto.UserLoginDTO;
import com.example.projectIsa.users.service.IUserService;

@RestController
@RequestMapping(value = "/users")
public class UsersController {
	
	private final IUserService userService;
	
	public UsersController(IUserService clientService) {
		this.userService = clientService;
	}
	
	/*@PostMapping(value = "/login", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody UserLoginDTO userLoginDTO){
        try{
            return new ResponseEntity(userService.login(userLoginDTO), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }*/
	

}
