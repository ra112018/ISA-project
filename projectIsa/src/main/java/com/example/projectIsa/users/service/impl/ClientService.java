package com.example.projectIsa.users.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.projectIsa.users.dto.ClientDTO;
import com.example.projectIsa.users.mapper.ClientMapper;
import com.example.projectIsa.users.model.Authority;
import com.example.projectIsa.users.model.Client;
import com.example.projectIsa.users.model.PasswordToken;
import com.example.projectIsa.users.repository.ClientRepository;
import com.example.projectIsa.users.repository.PasswordTokenRepository;
import com.example.projectIsa.users.service.IClientService;


@Service
public class ClientService implements IClientService{
	
	private final ClientRepository clientRepository;
	private PasswordEncoder passwordEncoder;
	private final AuthorityService authorityService;
	private final PasswordTokenService passwordTokenService;
	private final EmailService emailService;
	private final PasswordTokenRepository passwordTokenRepository;
	
	@Autowired
	public ClientService(ClientRepository clientRepository, PasswordEncoder passwordEncoder, AuthorityService authorityService, PasswordTokenService passwordTokenService,
			EmailService emailService,PasswordTokenRepository passwordTokenRepository) {
		this.clientRepository = clientRepository;
		this.passwordEncoder = passwordEncoder;
		this.authorityService = authorityService;
		this.passwordTokenService = passwordTokenService;
		this.emailService = emailService;
		this.passwordTokenRepository = passwordTokenRepository;
	}

	@Override
	public Client registerClient(ClientDTO clientDto) {
		Client client = ClientMapper.MapToClient(clientDto);
		client.setPassword(passwordEncoder.encode(clientDto.getPassword()));
		List<Authority> auth = authorityService.findByName("ROLE_CLIENT");
		client.setAuthorities(auth);
		passwordTokenService.createToken(clientDto.getEmail());
        emailService.clientApproveRegistrationMail(client);
		clientRepository.save(client);
		return client;
	}
	
	@Override
    public Client activateAccount(String token) {
		String email = passwordTokenRepository.findOneByToken(token).getEmail();

        if(email == null){
            return null;
        }
        
        Client client = clientRepository.findOneByEmail(email);
        PasswordToken passwordToken = passwordTokenRepository.findOneByEmail(email);
        
        Date now = new Date();
        if(passwordToken.getExpiryDate().before(now)){
            return null;
        }else {
        	client.setEnabled(true);
        	clientRepository.save(client);
            passwordTokenRepository.delete(passwordToken);
        }       
        
        return clientRepository.save(client);
    }
	
	@Override
    public Client findById(int id) {
		return clientRepository.getById(id);       
    }
	
	@Override
    public ClientDTO updateClient(ClientDTO dto) {
        Client client = clientRepository.findOneByEmail(dto.getEmail());
        client.setName(dto.getName());
        client.setSurname(dto.getSurname());
        client.setPhoneNumber(dto.getPhoneNumber());
        client.setAddress(dto.getAddress());
        clientRepository.save(client);
        return ClientMapper.MapToDTO(client);
    }

}
