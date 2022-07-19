package com.example.projectIsa.renting.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "boats")
@DiscriminatorValue(value = "Boat")
public class Boat extends RentingItem{

	public Boat() {
		super();
	}
}
