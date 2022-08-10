package com.example.projectIsa.users.repository;

import com.example.projectIsa.users.model.BoatOwner;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BoatOwnerRepository extends JpaRepository<BoatOwner, Integer> {
	BoatOwner findOneByEmail(String email);
	
    @Query(value = "SELECT b FROM BoatOwner b WHERE b.allowLoginBO=1")
	List<BoatOwner> findAllWhoRequestedRegistration();
}
