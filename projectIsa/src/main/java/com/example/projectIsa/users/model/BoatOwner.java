package com.example.projectIsa.users.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.example.projectIsa.users.model.enums.AllowedLogin;

@Entity
@DiscriminatorValue("BoatOwner")
public class BoatOwner extends User{
	
	private String explanationBO;

	private AllowedLogin allowLoginBO;

	public String getExplanationBO() {
		return explanationBO;
	}

	public void setExplanationBO(String explanationBO) {
		this.explanationBO = explanationBO;
	}

	public AllowedLogin getAllowLoginBO() {
		return allowLoginBO;
	}

	public void setAllowLoginBO(AllowedLogin allowLoginBO) {
		this.allowLoginBO = allowLoginBO;
	}
	
}
