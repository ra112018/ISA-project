package com.example.projectIsa.renting.model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.projectIsa.users.model.BoatOwner;
import com.example.projectIsa.users.model.FishingInstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "boats")
@DiscriminatorValue(value = "Boat")
public class Boat extends RentingItem{

	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
    private BoatOwner boatOwner;
    private String boatOwnerBiography;
    
    
	public Boat() {
		super();
	}

	public Boat(BoatOwner boatOwner, String boatOwnerBiography) {
		super();
		this.boatOwner = boatOwner;
		this.boatOwnerBiography = boatOwnerBiography;
	}
	
	public BoatOwner getBoatOwner() {
		return boatOwner;
	}
	public void setBoatOwner(BoatOwner boatOwner) {
		this.boatOwner = boatOwner;
	}
	public String getOwnerBiography() {
		return boatOwnerBiography;
	}
	public void setOwnerBiography(String boatOwnerBiography) {
		this.boatOwnerBiography = boatOwnerBiography;
	}
}
