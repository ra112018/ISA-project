package com.example.projectIsa.renting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.renting.model.Cottage;
import com.example.projectIsa.renting.repository.CottageRepository;
import com.example.projectIsa.renting.service.ICottageService;

@Service
public class CottageService implements ICottageService{

	private final CottageRepository cottageRepository;
	
	@Autowired
    public CottageService(CottageRepository cottageRepository) {
        this.cottageRepository = cottageRepository;
    }
	
	@Override
    public List<Cottage> getAll() {
		return cottageRepository.findAll();
    }
}
