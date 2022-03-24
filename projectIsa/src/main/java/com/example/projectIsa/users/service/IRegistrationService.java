package com.example.projectIsa.users.service;

import com.example.projectIsa.users.dto.ClientDTO;
import com.example.projectIsa.users.dto.OwnerDTO;
import com.example.projectIsa.users.model.Client;
import com.example.projectIsa.users.model.FishingInstructor;

public interface IRegistrationService {

	FishingInstructor registerInstructor(OwnerDTO ownerDto);
}
