package com.example.projectIsa.renting.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.renting.model.Boat;
import com.example.projectIsa.renting.model.Cottage;
import com.example.projectIsa.renting.repository.BoatRepository;
import com.example.projectIsa.renting.service.IBoatService;

@Service
public class BoatService implements IBoatService{

	private final BoatRepository boatRepository;
	
	@Autowired
    public BoatService(BoatRepository boatRepository) {
        this.boatRepository = boatRepository;
    }

	@Override
	public List<Boat> getAll() {
		return boatRepository.findAll();
	}
	
	@Override
	public List<Boat> search(String searchInput) {
		searchInput = searchInput.toLowerCase();
        List<Boat> allBoats = boatRepository.findAll();
        List<Boat> searchResults = new ArrayList<>();
        for (Boat boat : allBoats) {
            if (boat.getName().toLowerCase().contains(searchInput) || boat.getDescription().toLowerCase().contains(searchInput) || boat.getAddress().toLowerCase().contains(searchInput) ) {
                searchResults.add(boat);
            }
        }

        return searchResults;
	}
}
