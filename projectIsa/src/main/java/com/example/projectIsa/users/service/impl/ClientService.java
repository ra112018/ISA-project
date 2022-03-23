package com.example.projectIsa.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.users.dto.ClientDTO;
import com.example.projectIsa.users.mapper.ClientMapper;
import com.example.projectIsa.users.model.Client;
import com.example.projectIsa.users.repository.ClientRepository;
import com.example.projectIsa.users.service.IClientService;

@Service
public class ClientService implements IClientService{
	
	private final ClientRepository clientRepository;
	
	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public Client registerClient(ClientDTO clientDto) {
		Client client = ClientMapper.MapToClient(clientDto);
		//clientRepository.save(client);
		return client;
	}

}
