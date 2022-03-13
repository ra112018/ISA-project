package com.example.projectIsa.users.model;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue(value = "BoatOwner")
public class BoatOwner extends User{
	private String explanationBO;
	private String verificationBO;
	private Boolean isEnabledBO;
	
	public BoatOwner() {
		this.isEnabledBO = false;
	}

	public String getExplanationBO() {
		return explanationBO;
	}

	public void setExplanationBO(String explanationBO) {
		this.explanationBO = explanationBO;
	}

	public String getVerificationBO() {
		return verificationBO;
	}

	public void setVerificationBO(String verificationBO) {
		this.verificationBO = verificationBO;
	}

	public Boolean getIsEnabledBO() {
		return isEnabledBO;
	}

	public void setIsEnabledBO(Boolean isEnabledBO) {
		this.isEnabledBO = isEnabledBO;
	}
	
}
