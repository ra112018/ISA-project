package com.example.projectIsa.users.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.projectIsa.users.dto.OwnerDTO;
import com.example.projectIsa.users.dto.RegistrationRequestDTO;
import com.example.projectIsa.users.mapper.OwnerMapper;
import com.example.projectIsa.users.model.BoatOwner;
import com.example.projectIsa.users.model.CottageOwner;
import com.example.projectIsa.users.model.FishingInstructor;
import com.example.projectIsa.users.model.User;
import com.example.projectIsa.users.model.enums.AllowedLogin;
import com.example.projectIsa.users.repository.BoatOwnerRepository;
import com.example.projectIsa.users.repository.CottageOwnerRepository;
import com.example.projectIsa.users.repository.FishingInstructorRepository;
import com.example.projectIsa.users.repository.UserRepository;
import com.example.projectIsa.users.service.IRegistrationService;

@Service
public class RegistrationService implements IRegistrationService {
	
	private final FishingInstructorRepository instructorRepository;
	private final UserRepository userRepository;
	private final BoatOwnerRepository boatOwnerRepository;
	private final CottageOwnerRepository cottageOwnerRepository;
	private final EmailService emailService;
	private PasswordEncoder passwordEncoder;

		
	@Autowired
	public RegistrationService(FishingInstructorRepository instructorRepository, UserRepository userRepository,
			BoatOwnerRepository boatOwnerRepository, CottageOwnerRepository cottageOwnerRepository,
			EmailService emailService, PasswordEncoder passwordEncoder
			) {
		this.instructorRepository = instructorRepository;
		this.userRepository = userRepository;
		this.boatOwnerRepository = boatOwnerRepository;
		this.cottageOwnerRepository = cottageOwnerRepository;
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
	public BoatOwner registerBoatOwner(OwnerDTO ownerDto) throws Exception {
		if(userRepository.findByEmail(ownerDto.getEmail())!= null) {
			throw new Exception("Email is not unique!");
		} else {
		BoatOwner boatOwner = OwnerMapper.MapToBoatOwner(ownerDto);
		boatOwner.setDeleted(false);
		boatOwner.setPassword(passwordEncoder.encode(ownerDto.getPassword()));
		boatOwner.setAllowLoginBO(AllowedLogin.WaitingAdmin);
		boatOwnerRepository.save(boatOwner);
		return boatOwner;
		}
	}
	
	@Override
	public CottageOwner registerCottageOwner(OwnerDTO ownerDto) throws Exception {
		if(userRepository.findByEmail(ownerDto.getEmail())!= null) {
			throw new Exception("Email is not unique!");
		} else {
		CottageOwner cottageOwner = OwnerMapper.MapToCottageOwner(ownerDto);
		cottageOwner.setDeleted(false);
		cottageOwner.setPassword(passwordEncoder.encode(ownerDto.getPassword()));
		cottageOwner.setAllowLoginCO(AllowedLogin.WaitingAdmin);
		cottageOwnerRepository.save(cottageOwner);
		return cottageOwner;
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
	public List<RegistrationRequestDTO> getRegistrationsRequests() {
		List<BoatOwner> boatOwners = boatOwnerRepository.findAllWhoRequestedRegistration();
		System.out.println(boatOwners.size());
		List<RegistrationRequestDTO> requests = new ArrayList();
		for(int i=0; i<boatOwners.size();i++) {
			RegistrationRequestDTO request = new RegistrationRequestDTO(boatOwners.get(i).getEmail(),
					boatOwners.get(i).getName(),boatOwners.get(i).getSurname(),boatOwners.get(i).getRole(),
					boatOwners.get(i).getExplanationBO());
			requests.add(request);
		}
		return requests;
	}
	
	@Override
	public List<RegistrationRequestDTO> getRegistrationsRequest() {
		List<CottageOwner> cottageOwner = cottageOwnerRepository.findAllWhoRequestedRegistration();
		System.out.println(cottageOwner.size());
		List<RegistrationRequestDTO> requests = new ArrayList();
		for(int i=0; i<cottageOwner.size();i++) {
			RegistrationRequestDTO request = new RegistrationRequestDTO(cottageOwner.get(i).getEmail(),
					cottageOwner.get(i).getName(),cottageOwner.get(i).getSurname(),cottageOwner.get(i).getRole(),
					cottageOwner.get(i).getExplanationCO());
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
		else if(role.equals("BoatOwner")) {
			BoatOwner boatOwner = boatOwnerRepository.findOneByEmail(email);
			boatOwner.setAllowLoginBO(AllowedLogin.Allowed);
			boatOwner.setEnabled(true);
			boatOwnerRepository.save(boatOwner);
			emailService.sendAllowedRegistrationEmail(email, boatOwner.getName(), boatOwner.getSurname());
		}
		else if(role.equals("CottageOwner")) {
			CottageOwner cottageOwner = cottageOwnerRepository.findOneByEmail(email);
			cottageOwner.setAllowLoginCO(AllowedLogin.Allowed);
			cottageOwner.setEnabled(true);
			cottageOwnerRepository.save(cottageOwner);
			emailService.sendAllowedRegistrationEmail(email, cottageOwner.getName(), cottageOwner.getSurname());
		}
	}

	@Override
	public void denyRegistrationRequest(RegistrationRequestDTO registrationRequestDTO) {
		if(registrationRequestDTO.getRole().equals("FishingInstructor")) {
			FishingInstructor instructor = instructorRepository.findOneByEmail(registrationRequestDTO.getEmail());
			instructor.setAllowLogin(AllowedLogin.Rejected);
			instructor.setEnabled(false);
			instructorRepository.save(instructor);
			emailService.sendDeniedRegistrationEmail(instructor.getEmail(), instructor.getName(), instructor.getSurname(), registrationRequestDTO.getExplanation());
			
		}
		else if(registrationRequestDTO.getRole().equals("BoatOwner")) {
			BoatOwner boatOwner = boatOwnerRepository.findOneByEmail(registrationRequestDTO.getEmail());
			boatOwner.setAllowLoginBO(AllowedLogin.Rejected);
			boatOwner.setEnabled(false);
			boatOwnerRepository.save(boatOwner);
			emailService.sendDeniedRegistrationEmail(boatOwner.getEmail(), boatOwner.getName(), boatOwner.getSurname(), registrationRequestDTO.getExplanation());
			
		}
		else if(registrationRequestDTO.getRole().equals("CottageOwner")) {
			CottageOwner cottageOwner = cottageOwnerRepository.findOneByEmail(registrationRequestDTO.getEmail());
			cottageOwner.setAllowLoginCO(AllowedLogin.Rejected);
			cottageOwner.setEnabled(false);
			cottageOwnerRepository.save(cottageOwner);
			emailService.sendDeniedRegistrationEmail(cottageOwner.getEmail(), cottageOwner.getName(), cottageOwner.getSurname(), registrationRequestDTO.getExplanation());
			
		}
	}
}
