package com.example.projectIsa.users.repository;

import com.example.projectIsa.users.model.FishingInstructor;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FishingInstructorRepository extends JpaRepository<FishingInstructor, Integer> {

	FishingInstructor findOneByEmail(String email);
	
    @Query(value = "SELECT c FROM FishingInstructor c WHERE c.allowLogin=1") //valjda ceka admina ali proveriti
	List<FishingInstructor> findAllWhoRequestedRegistration();
	
}
