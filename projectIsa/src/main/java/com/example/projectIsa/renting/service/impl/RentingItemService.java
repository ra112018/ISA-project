package com.example.projectIsa.renting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.renting.model.RentingItem;
import com.example.projectIsa.renting.repository.RentingItemRepository;
import com.example.projectIsa.renting.service.IRentingItemService;

@Service
public class RentingItemService implements IRentingItemService{

	private final RentingItemRepository rentingItemRepository;

    @Autowired
    public RentingItemService(RentingItemRepository rentingItemRepository) {
        this.rentingItemRepository = rentingItemRepository;
    }
    
	@Override
	public RentingItem findById(Integer rentingItemId) {
		return rentingItemRepository.getById(rentingItemId);
	}

}
