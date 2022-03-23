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

import com.example.projectIsa.users.dto.ClientDTO;
import com.example.projectIsa.users.service.IClientService;

@RestController
@RequestMapping(value = "/registration-client")
public class ClientsController {
	
	private final IClientService clientService;
	
	public ClientsController(IClientService clientService) {
		this.clientService = clientService;
	}
	
	@GetMapping(value = "/hello")
	public String hello () {
		System.out.println("Ovde hello");
	    return "Hello";
	}
	
	@PostMapping(value = "/registration", consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registerClient(@RequestBody ClientDTO clientDto) throws ParseException {
		try {
			System.out.println("Ovde");
			System.out.println(clientDto);
			clientService.registerClient(clientDto);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
