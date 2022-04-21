package com.example.projectIsa.users.repository;

import com.example.projectIsa.users.model.FishingInstructor;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FishingInstructorRepository extends JpaRepository<FishingInstructor, Integer> {
	
}
