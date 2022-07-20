package com.example.projectIsa.renting.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cottages")
@DiscriminatorValue(value = "Cottage")
public class Cottage extends RentingItem{

	public Cottage() {
		super();
	}

}
