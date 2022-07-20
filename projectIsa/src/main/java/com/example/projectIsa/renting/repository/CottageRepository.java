package com.example.projectIsa.renting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectIsa.renting.model.Cottage;


@Repository
public interface CottageRepository extends JpaRepository<Cottage,Integer>{

}
