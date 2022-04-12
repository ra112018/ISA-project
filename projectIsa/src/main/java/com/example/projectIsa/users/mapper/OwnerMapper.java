package com.example.projectIsa.users.mapper;

import com.example.projectIsa.users.dto.ClientDTO;
import com.example.projectIsa.users.dto.OwnerDTO;
import com.example.projectIsa.users.model.Address;
import com.example.projectIsa.users.model.Client;
import com.example.projectIsa.users.model.FishingInstructor;

public class OwnerMapper {
	public static FishingInstructor MapToOwner(OwnerDTO ownerDto) {
		FishingInstructor fishingInstructor = new FishingInstructor();
		fishingInstructor.setName(ownerDto.getName());
		fishingInstructor.setSurname(ownerDto.getSurname());
		fishingInstructor.setEmail(ownerDto.getEmail());
		fishingInstructor.setPassword(ownerDto.getPassword());
		fishingInstructor.setPhoneNumber(ownerDto.getPhoneNumber());
		fishingInstructor.setRole(ownerDto.getRole());
		
		Address address = new Address();
		address.setState(ownerDto.getAddress());
		address.setUser(fishingInstructor);
	/*	address.setCity(ownerDto.getAddress().getCity());
		address.setStreet(ownerDto.getAddress().getStreet());
		address.setHouseNumber(ownerDto.getAddress().getHouseNumber());
		address.setPostcode(ownerDto.getAddress().getPostcode());*/
		
		//fishingInstructor.setAddress(address);
		
		return fishingInstructor;
	}
}
