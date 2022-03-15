package com.example.projectIsa.users.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CottageOwner")
public class CottageOwner extends User{

	private String explanationCO;

	private String verificationCO;

	private Boolean isEnabledCO;
	
	public CottageOwner() {
		this.isEnabledCO = false;
	}

	public String getExplanationCO() {
		return explanationCO;
	}

	public void setExplanationCO(String explanationCO) {
		this.explanationCO = explanationCO;
	}

	public String getVerificationCO() {
		return verificationCO;
	}

	public void setVerificationCO(String verificationCO) {
		this.verificationCO = verificationCO;
	}

	public Boolean getIsEnabledCO() {
		return isEnabledCO;
	}

	public void setIsEnabledCO(Boolean isEnabledCO) {
		this.isEnabledCO = isEnabledCO;
	}
	
}
