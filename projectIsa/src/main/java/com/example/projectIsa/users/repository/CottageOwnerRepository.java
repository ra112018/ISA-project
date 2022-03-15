package com.example.projectIsa.users.repository;

import com.example.projectIsa.users.model.CottageOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CottageOwnerRepository extends JpaRepository<CottageOwner, Integer> {
    
}
