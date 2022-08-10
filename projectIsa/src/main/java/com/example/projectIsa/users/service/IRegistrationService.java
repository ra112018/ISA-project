package com.example.projectIsa.users.service;

import java.util.List;

import com.example.projectIsa.users.dto.OwnerDTO;
import com.example.projectIsa.users.dto.RegistrationRequestDTO;
import com.example.projectIsa.users.model.BoatOwner;
import com.example.projectIsa.users.model.CottageOwner;
import com.example.projectIsa.users.model.FishingInstructor;

public interface IRegistrationService {

	FishingInstructor registerInstructor(OwnerDTO ownerDto) throws Exception;

	List<RegistrationRequestDTO> getRegistrationRequests();

	void acceptRegistrationRequest(String email, String role);

	void denyRegistrationRequest(RegistrationRequestDTO registrationRequestDTO);

	BoatOwner registerBoatOwner(OwnerDTO ownerDto) throws Exception;

	CottageOwner registerCottageOwner(OwnerDTO ownerDto) throws Exception;

	List<RegistrationRequestDTO> getRegistrationsRequests();

	List<RegistrationRequestDTO> getRegistrationsRequest();
}
