package com.example.projectIsa.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.users.dto.OwnerDTO;
import com.example.projectIsa.users.mapper.OwnerMapper;
import com.example.projectIsa.users.model.FishingInstructor;
import com.example.projectIsa.users.repository.FishingInstructorRepository;
import com.example.projectIsa.users.service.IRegistrationService;

@Service
public class RegistrationService implements IRegistrationService {
	
	private final FishingInstructorRepository instructorRepository;
		
	@Autowired
	public RegistrationService(FishingInstructorRepository instructorRepository) {
		this.instructorRepository = instructorRepository;
	}

	@Override
	public FishingInstructor registerInstructor(OwnerDTO ownerDto) {
		FishingInstructor instructor = OwnerMapper.MapToOwner(ownerDto);
		instructorRepository.save(instructor);
		return instructor;
	}

}
