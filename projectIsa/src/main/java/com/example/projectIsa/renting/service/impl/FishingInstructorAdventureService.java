package com.example.projectIsa.renting.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectIsa.renting.model.FishingInstructorAdventure;
import com.example.projectIsa.renting.repository.FishingInstructorAdventureRepository;
import com.example.projectIsa.renting.service.IFishingInstructorAdventureService;

@Service
public class FishingInstructorAdventureService implements IFishingInstructorAdventureService{

	private final FishingInstructorAdventureRepository fishingInstructorAdventureRepository;
	
	@Autowired
    public FishingInstructorAdventureService(FishingInstructorAdventureRepository fishingInstructorAdventureRepository) {
        this.fishingInstructorAdventureRepository = fishingInstructorAdventureRepository;
    }
	
	@Override
	public List<FishingInstructorAdventure> getAll() {
		return fishingInstructorAdventureRepository.findAll();
	}

	@Override
	public List<FishingInstructorAdventure> search(String searchInput) {
		searchInput = searchInput.toLowerCase();
        List<FishingInstructorAdventure> allFishingInstructorAdventure = fishingInstructorAdventureRepository.findAll();
        List<FishingInstructorAdventure> searchResults = new ArrayList<>();
        for (FishingInstructorAdventure fishingInstructorAdventure : allFishingInstructorAdventure) {
            if (fishingInstructorAdventure.getName().toLowerCase().contains(searchInput) || fishingInstructorAdventure.getDescription().toLowerCase().contains(searchInput) || fishingInstructorAdventure.getAddress().toLowerCase().contains(searchInput) ) {
                searchResults.add(fishingInstructorAdventure);
            }
        }

        return searchResults;
	}

}
