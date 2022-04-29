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
import com.example.projectIsa.users.service.IUserService;

@RestController
@RequestMapping(value = "/registration-owner-instructor")
public class RegistrationController {

	private final IRegistrationService registrationService;
	private final IUserService userService;

	
	public RegistrationController(IRegistrationService registrationService, IUserService userService) {
		this.registrationService = registrationService;
		this.userService = userService;

	}
	
	@GetMapping(value = "/hello")
	public String hello () {
		System.out.println("Ovde hello");
	    return "Hello";
	}
	
	@PostMapping(value = "/registration", consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  registrationOwner(@RequestBody OwnerDTO ownerDto) throws ParseException {
		try {
			if(!userService.checkUniqueUsername(ownerDto.getEmail())) {
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);

			}
			registrationService.registerInstructor(ownerDto);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/requests")
	public ResponseEntity<?> getRegistrationRequests() {
		try {
			return new ResponseEntity<>(registrationService.getRegistrationRequests(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
