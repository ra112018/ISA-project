package com.example.projectIsa.renting.model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.projectIsa.users.model.FishingInstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="fishingInstructorAdventure")
@DiscriminatorValue(value = "FishingInstructorAdventure")
public class FishingInstructorAdventure extends RentingItem{

	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
    private FishingInstructor fishingInstructor;
    private String instructorBiography;
    
    
	public FishingInstructorAdventure() {
		super();
	}

	public FishingInstructorAdventure(FishingInstructor fishingInstructor, String instructorBiography) {
		super();
		this.fishingInstructor = fishingInstructor;
		this.instructorBiography = instructorBiography;
	}
	
	public FishingInstructor getFishingInstructor() {
		return fishingInstructor;
	}
	public void setFishingInstructor(FishingInstructor fishingInstructor) {
		this.fishingInstructor = fishingInstructor;
	}
	public String getInstructorBiography() {
		return instructorBiography;
	}
	public void setInstructorBiography(String instructorBiography) {
		this.instructorBiography = instructorBiography;
	}
    
    
}
