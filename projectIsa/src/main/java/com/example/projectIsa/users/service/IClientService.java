package com.example.projectIsa.users.service;

import com.example.projectIsa.users.dto.ClientDTO;
import com.example.projectIsa.users.model.Client;

public interface IClientService {

	Client registerClient(ClientDTO clientDto);
	
	Client activateAccount(String token);
}
