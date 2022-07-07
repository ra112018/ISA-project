package com.example.projectIsa.users.mapper;

import com.example.projectIsa.users.dto.ClientDTO;
import com.example.projectIsa.users.model.Address;
import com.example.projectIsa.users.model.Client;

public class ClientMapper {
	
	public ClientMapper() {}
	
	public static Client MapToClient(ClientDTO clientDto) {
		Client client = new Client();
		client.setName(clientDto.getName());
		client.setSurname(clientDto.getSurname());
		client.setEmail(clientDto.getEmail());
		client.setPassword(clientDto.getPassword());
		client.setPhoneNumber(clientDto.getPhoneNumber());
		client.setDeleted(false);

		
		Address address = new Address();
		address.setState(clientDto.getAddress().getState());
		address.setCity(clientDto.getAddress().getCity());
		address.setStreet(clientDto.getAddress().getStreet());
		address.setHouseNumber(clientDto.getAddress().getHouseNumber());
		address.setPostcode(clientDto.getAddress().getPostcode());
		
		client.setAddress(address);
		
		return client;
	}

}
