package com.example.projectIsa.users.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Hello";
	}

}
