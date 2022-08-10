package com.example.projectIsa.renting.model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.projectIsa.users.model.BoatOwner;
import com.example.projectIsa.users.model.CottageOwner;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cottages")
@DiscriminatorValue(value = "Cottage")
public class Cottage extends RentingItem{

	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
    private CottageOwner cottageOwner;
    private String cottageOwnerBiography;
    
    
	public Cottage() {
		super();
	}

	public Cottage(CottageOwner cottageOwner, String cottageOwnerBiography) {
		super();
		this.cottageOwner = cottageOwner;
		this.cottageOwnerBiography = cottageOwnerBiography;
	}
	
	public CottageOwner getCottageOwner() {
		return cottageOwner;
	}
	public void setCottageOwner(CottageOwner cottageOwner) {
		this.cottageOwner = cottageOwner;
	}
	public String getCottageOwnerBiography() {
		return cottageOwnerBiography;
	}
	public void setCottageOwnerBiography(String cottageOwnerBiography) {
		this.cottageOwnerBiography = cottageOwnerBiography;
	}
}
