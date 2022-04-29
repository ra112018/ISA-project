package com.example.projectIsa.users.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.users.dto.AccessTokenDTO;
import com.example.projectIsa.users.dto.OwnerDTO;
import com.example.projectIsa.users.dto.UserLoginDTO;
import com.example.projectIsa.users.model.Administrator;
import com.example.projectIsa.users.model.FishingInstructor;
import com.example.projectIsa.users.model.User;
import com.example.projectIsa.users.repository.AdministratorRepository;
import com.example.projectIsa.users.repository.BoatOwnerRepository;
import com.example.projectIsa.users.repository.ClientRepository;
import com.example.projectIsa.users.repository.CottageOwnerRepository;
import com.example.projectIsa.users.repository.FishingInstructorRepository;
import com.example.projectIsa.users.service.IUserService;

import antlr.collections.List;

@Service
public class UserService implements IUserService{
	
	private final FishingInstructorRepository instructorRepository;
	private final AdministratorRepository administratorRepository;
	private final BoatOwnerRepository boatOwnerRepository;
	private final ClientRepository clientRepository;
	private final CottageOwnerRepository cottageOwnerRepository;


	@Autowired
	public UserService(AdministratorRepository adminRepo, BoatOwnerRepository boRepo, 
			ClientRepository clientRepo, CottageOwnerRepository coRepo, FishingInstructorRepository instructorRepository) {
		this.instructorRepository = instructorRepository;
		this.administratorRepository = adminRepo;
		this.boatOwnerRepository = boRepo;
		this.clientRepository = clientRepo;
		this.cottageOwnerRepository = coRepo;
	}
	
	@Override
	public Boolean checkUniqueUsername(String email) {
		FishingInstructor instructor = instructorRepository.findOneByEmail(email);
		if(instructor != null)
				return false;
		
		return true;
	}

	@Override
	public AccessTokenDTO login(UserLoginDTO userLoginDTO) {
		// TODO Auto-generated method stub
		FishingInstructor instructor = instructorRepository.findOneByEmail(userLoginDTO.getUsername());
        if (instructor != null && instructor.getPassword().equals(userLoginDTO.getPassword())) {
            return new AccessTokenDTO(userLoginDTO, "",instructor.getRole(),instructor.getId(),(long) 7200);
        }
        System.out.println(userLoginDTO.getUsername()+"email");
        Administrator admin = administratorRepository.findOneByEmail(userLoginDTO.getUsername());
        System.out.println(admin.getEmail()+"email admin");

        if (admin != null && admin.getPassword().equals(userLoginDTO.getPassword())) {
            return new AccessTokenDTO(userLoginDTO, "",admin.getRole(), admin.getId() ,(long) 7200);
        }
		return null;
	}
}
