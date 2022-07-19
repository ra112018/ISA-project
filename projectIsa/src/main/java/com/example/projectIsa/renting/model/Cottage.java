package com.example.projectIsa.renting.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cottages")
@DiscriminatorValue(value = "Cottage")
public class Cottage extends RentingItem{

	private String rules;
	

	public Cottage() {
		super();
	}

	public Cottage(String rules) {
		super();
		this.rules = rules;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}
	
	
}
