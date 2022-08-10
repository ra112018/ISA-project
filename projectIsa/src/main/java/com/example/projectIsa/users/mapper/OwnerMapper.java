package com.example.projectIsa.users.mapper;

import com.example.projectIsa.users.dto.OwnerDTO;
import com.example.projectIsa.users.model.Address;
import com.example.projectIsa.users.model.BoatOwner;
import com.example.projectIsa.users.model.CottageOwner;
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
	
	public static BoatOwner MapToBoatOwner(OwnerDTO ownerDto) {
		BoatOwner boatOwner = new BoatOwner();
		boatOwner.setName(ownerDto.getName());
		boatOwner.setSurname(ownerDto.getSurname());
		boatOwner.setEmail(ownerDto.getEmail());
		boatOwner.setPassword(ownerDto.getPassword());
		boatOwner.setPhoneNumber(ownerDto.getPhoneNumber());
		boatOwner.setRole(ownerDto.getRole());
		boatOwner.setExplanationBO(ownerDto.getExplanation());
		
		Address address = MapToAddress(ownerDto);
		address.setUser(boatOwner);
		boatOwner.setAddress(address);
		
		return boatOwner;
	}
	
	public static CottageOwner MapToCottageOwner(OwnerDTO ownerDto) {
		CottageOwner cottageOwner = new CottageOwner();
		cottageOwner.setName(ownerDto.getName());
		cottageOwner.setSurname(ownerDto.getSurname());
		cottageOwner.setEmail(ownerDto.getEmail());
		cottageOwner.setPassword(ownerDto.getPassword());
		cottageOwner.setPhoneNumber(ownerDto.getPhoneNumber());
		cottageOwner.setRole(ownerDto.getRole());
		cottageOwner.setExplanationCO(ownerDto.getExplanation());
		
		Address address = MapToAddress(ownerDto);
		address.setUser(cottageOwner);
		cottageOwner.setAddress(address);
		
		return cottageOwner;
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
