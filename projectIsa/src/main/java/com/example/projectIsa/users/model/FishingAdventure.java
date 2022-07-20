package com.example.projectIsa.users.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="adventures")
public class FishingAdventure {
	
	@Id
	@SequenceGenerator(name = "adventure_entity_id_seq", sequenceName = "adventure_entity_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adventure_entity_id_seq")
	private Integer id;
	
	private String name;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="adress_id", referencedColumnName = "id")
	private Address address;
	
	private String description;
	
	
	private String instructorBiography;
	
	private int maxNumberOfPeople;
	
		
	String allowed;
	
	String notAllowed;
	
	
	String ifCancelled;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstructorBiography() {
		return instructorBiography;
	}

	public void setInstructorBiography(String instructorBiography) {
		this.instructorBiography = instructorBiography;
	}

	public int getMaxNumberOfPeople() {
		return maxNumberOfPeople;
	}

	public void setMaxNumberOfPeople(int maxNumberOfPeople) {
		this.maxNumberOfPeople = maxNumberOfPeople;
	}

	public String getAllowed() {
		return allowed;
	}

	public void setAllowed(String allowed) {
		this.allowed = allowed;
	}

	public String getNotAllowed() {
		return notAllowed;
	}

	public void setNotAllowed(String notAllowed) {
		this.notAllowed = notAllowed;
	}

	public String getIfCancelled() {
		return ifCancelled;
	}

	public void setIfCancelled(String ifCancelled) {
		this.ifCancelled = ifCancelled;
	}
	
	
}
