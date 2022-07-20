package com.example.projectIsa.renting.service;

import java.util.List;

import com.example.projectIsa.renting.model.Cottage;

public interface ICottageService {

	List<Cottage> getAll();

	List<Cottage> search(String searchInput);

}
