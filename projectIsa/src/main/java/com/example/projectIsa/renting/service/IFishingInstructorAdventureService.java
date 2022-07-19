package com.example.projectIsa.renting.service;

import java.util.List;

import com.example.projectIsa.renting.model.FishingInstructorAdventure;

public interface IFishingInstructorAdventureService {

	List<FishingInstructorAdventure> getAll();

	List<FishingInstructorAdventure> search(String searchInput);

}
