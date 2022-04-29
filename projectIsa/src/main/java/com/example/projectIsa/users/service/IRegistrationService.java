package com.example.projectIsa.users.service;

import java.util.List;

import com.example.projectIsa.users.dto.OwnerDTO;
import com.example.projectIsa.users.dto.RegistrationRequestDTO;
import com.example.projectIsa.users.model.FishingInstructor;

public interface IRegistrationService {

	FishingInstructor registerInstructor(OwnerDTO ownerDto);

	List<RegistrationRequestDTO> getRegistrationRequests();
}
