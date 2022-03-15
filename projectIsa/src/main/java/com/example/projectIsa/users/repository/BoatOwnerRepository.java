package com.example.projectIsa.users.repository;

import com.example.projectIsa.users.model.BoatOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoatOwnerRepository extends JpaRepository<BoatOwner, Integer> {
    
}
