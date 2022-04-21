package com.example.projectIsa.users.mapper;

import com.example.projectIsa.users.dto.OwnerDTO;
import com.example.projectIsa.users.model.Address;
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
		fishingInstructor.setExplanation(ownerDto.getExplanation());
		
		Address address = MapToAddress(ownerDto);
		address.setUser(fishingInstructor);
		fishingInstructor.setAddress(address);
		
		return fishingInstructor;
	}

	public static Address MapToAddress(OwnerDTO ownerDto) {
		// TODO Auto-generated method stub
		Address address = new Address();
		address.setState(ownerDto.getState());
		address.setCity(ownerDto.getCity());
		address.setStreet(ownerDto.getStreet());
		address.setHouseNumber(ownerDto.getHouseNumber());
		address.setPostcode(ownerDto.getPostcode());

		return address;
	}

}
