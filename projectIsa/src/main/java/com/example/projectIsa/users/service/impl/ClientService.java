package com.example.projectIsa.users.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.projectIsa.users.dto.ClientDTO;
import com.example.projectIsa.users.mapper.ClientMapper;
import com.example.projectIsa.users.model.Authority;
import com.example.projectIsa.users.model.Client;
import com.example.projectIsa.users.repository.ClientRepository;
import com.example.projectIsa.users.service.IClientService;

@Service
public class ClientService implements IClientService{
	
	private final ClientRepository clientRepository;
	private PasswordEncoder passwordEncoder;
	private final AuthorityService authorityService;
	
	@Autowired
	public ClientService(ClientRepository clientRepository, PasswordEncoder passwordEncoder, AuthorityService authorityService) {
		this.clientRepository = clientRepository;
		this.passwordEncoder = passwordEncoder;
		this.authorityService = authorityService;
	}

	@Override
	public Client registerClient(ClientDTO clientDto) {
		Client client = ClientMapper.MapToClient(clientDto);
		client.setPassword(passwordEncoder.encode(clientDto.getPassword()));
		List<Authority> auth = authorityService.findByName("ROLE_CLIENT");
		client.setAuthorities(auth);
		clientRepository.save(client);
		return client;
	}

}
