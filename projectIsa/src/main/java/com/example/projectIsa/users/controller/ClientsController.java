package com.example.projectIsa.users.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.users.service.IClientService;

@RestController
@RequestMapping(value = "/registration-client")
public class ClientsController {
	
	private final IClientService clientService;
	
	public ClientsController(IClientService clientService) {
		this.clientService = clientService;
	}

}
