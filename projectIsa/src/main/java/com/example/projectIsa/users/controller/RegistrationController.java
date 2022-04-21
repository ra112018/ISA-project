package com.example.projectIsa.users.controller;

import java.text.ParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.users.dto.OwnerDTO;
import com.example.projectIsa.users.service.IRegistrationService;

@RestController
@RequestMapping(value = "/registration-owner-instructor")
public class RegistrationController {

	private final IRegistrationService registrationService;
	
	public RegistrationController(IRegistrationService registrationService) {
		this.registrationService = registrationService;
	}
	
	@GetMapping(value = "/hello")
	public String hello () {
		System.out.println("Ovde hello");
	    return "Hello";
	}
	
	@PostMapping(value = "/registration", consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  registrationOwner(@RequestBody OwnerDTO ownerDto) throws ParseException {
		try {
			registrationService.registerInstructor(ownerDto);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
