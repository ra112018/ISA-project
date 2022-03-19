package com.example.projectIsa.users.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BoatOwner")
public class BoatOwner extends User{

	private String explanation;
	
	private String verification;

	private Boolean isEnabled;
	
	public BoatOwner() {
		this.isEnabled = false;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getVerification() {
		return verification;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabledBO(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
}
