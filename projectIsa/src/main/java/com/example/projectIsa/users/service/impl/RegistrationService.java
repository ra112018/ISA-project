package com.example.projectIsa.users.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.users.dto.OwnerDTO;
import com.example.projectIsa.users.dto.RegistrationRequestDTO;
import com.example.projectIsa.users.mapper.OwnerMapper;
import com.example.projectIsa.users.model.FishingInstructor;
import com.example.projectIsa.users.model.enums.AllowedLogin;
import com.example.projectIsa.users.repository.FishingInstructorRepository;
import com.example.projectIsa.users.service.IRegistrationService;
import com.example.projectIsa.users.service.IUserService;

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
		instructor.setDeleted(false);
		instructor.setAllowLogin(AllowedLogin.WaitingAdmin);
		instructorRepository.save(instructor);
		return instructor;
	}

	@Override
	public List<RegistrationRequestDTO> getRegistrationRequests() {
		List<FishingInstructor> instructors = instructorRepository.findAllWhoRequestedRegistration();
		List<RegistrationRequestDTO> requests = new ArrayList();
		for(int i=0; i<instructors.size();i++) {
			RegistrationRequestDTO request = new RegistrationRequestDTO(instructors.get(i).getEmail(),
					instructors.get(i).getName(),instructors.get(i).getSurname(),instructors.get(i).getRole(),
					instructors.get(i).getExplanation());
			requests.add(request);
		}
		return requests;
	}
}
