package com.example.projectIsa.renting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectIsa.renting.model.RentingItem;

@Repository
public interface RentingItemRepository extends JpaRepository<RentingItem,Integer>{

}
