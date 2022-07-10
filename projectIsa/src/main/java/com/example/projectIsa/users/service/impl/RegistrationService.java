package com.example.projectIsa.users.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.projectIsa.users.dto.OwnerDTO;
import com.example.projectIsa.users.dto.RegistrationRequestDTO;
import com.example.projectIsa.users.mapper.OwnerMapper;
import com.example.projectIsa.users.model.FishingInstructor;
import com.example.projectIsa.users.model.User;
import com.example.projectIsa.users.model.enums.AllowedLogin;
import com.example.projectIsa.users.repository.FishingInstructorRepository;
import com.example.projectIsa.users.repository.UserRepository;
import com.example.projectIsa.users.service.IRegistrationService;

@Service
public class RegistrationService implements IRegistrationService {
	
	private final FishingInstructorRepository instructorRepository;
	private final UserRepository userRepository;
	private final EmailService emailService;
	private PasswordEncoder passwordEncoder;

		
	@Autowired
	public RegistrationService(FishingInstructorRepository instructorRepository, UserRepository userRepository,
			EmailService emailService, PasswordEncoder passwordEncoder
) {
		this.instructorRepository = instructorRepository;
		this.userRepository = userRepository;
		this.emailService = emailService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public FishingInstructor registerInstructor(OwnerDTO ownerDto) throws Exception {
		if(userRepository.findByEmail(ownerDto.getEmail())!= null) {
			throw new Exception("Email is not unique!");
		} else {
		FishingInstructor instructor = OwnerMapper.MapToOwner(ownerDto);
		instructor.setDeleted(false);
		instructor.setPassword(passwordEncoder.encode(ownerDto.getPassword()));
		instructor.setAllowLogin(AllowedLogin.WaitingAdmin);
		instructorRepository.save(instructor);
		return instructor;
		}
	}

	@Override
	public List<RegistrationRequestDTO> getRegistrationRequests() {
		List<FishingInstructor> instructors = instructorRepository.findAllWhoRequestedRegistration();
		System.out.println(instructors.size());
		List<RegistrationRequestDTO> requests = new ArrayList();
		for(int i=0; i<instructors.size();i++) {
			RegistrationRequestDTO request = new RegistrationRequestDTO(instructors.get(i).getEmail(),
					instructors.get(i).getName(),instructors.get(i).getSurname(),instructors.get(i).getRole(),
					instructors.get(i).getExplanation());
			requests.add(request);
		}
		return requests;
	}

	@Override
	public void acceptRegistrationRequest(String email, String role) {
		if(role.equals("FishingInstructor")) {
			FishingInstructor instructor = instructorRepository.findOneByEmail(email);
			instructor.setAllowLogin(AllowedLogin.Allowed);
			instructor.setEnabled(true);
			instructorRepository.save(instructor);
			emailService.sendAllowedRegistrationEmail(email, instructor.getName(), instructor.getSurname());
		}
		
	}

	@Override
	public void denyRegistrationRequest(String email, String role) {
		if(role.equals("FishingInstructor")) {
			FishingInstructor instructor = instructorRepository.findOneByEmail(email);
			instructor.setAllowLogin(AllowedLogin.Rejected);
			emailService.sendDeniedRegistrationEmail(email, instructor.getName(), instructor.getSurname());
			
		}		
	}
}
