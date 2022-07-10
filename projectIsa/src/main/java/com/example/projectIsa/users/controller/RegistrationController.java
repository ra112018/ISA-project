package com.example.projectIsa.users.controller;

import java.text.ParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.users.dto.OwnerDTO;
import com.example.projectIsa.users.dto.RegistrationRequestDTO;
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
	
	
	@PostMapping(value = "/registration", consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  registrationOwner(@RequestBody OwnerDTO ownerDto) throws Exception {
		try {
			registrationService.registerInstructor(ownerDto);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
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
	
	@PutMapping(value = "/acceptRegistrationRequest")
	public void acceptRegistrationRequest(@RequestBody RegistrationRequestDTO requestDTO){
		registrationService.acceptRegistrationRequest(requestDTO.getEmail(), requestDTO.getRole());
	}

	@PutMapping("/denyRegistrationRequest")
	public void denyRegistrationRequest(@RequestBody String email, String role){
		registrationService.denyRegistrationRequest(email, role);
	}

}
