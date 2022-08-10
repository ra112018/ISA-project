package com.example.projectIsa.users.repository;

import com.example.projectIsa.users.model.CottageOwner;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CottageOwnerRepository extends JpaRepository<CottageOwner, Integer> {
	CottageOwner findOneByEmail(String email);
	
    @Query(value = "SELECT o FROM CottageOwner o WHERE o.allowLoginCO=1")
	List<CottageOwner> findAllWhoRequestedRegistration();
}
