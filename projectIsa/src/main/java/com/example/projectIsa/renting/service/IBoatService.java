package com.example.projectIsa.renting.service;

import java.util.List;

import com.example.projectIsa.renting.model.Boat;

public interface IBoatService {

	List<Boat> getAll();

	List<Boat> search(String searchInput);

}
