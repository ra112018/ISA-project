package com.example.projectIsa.users.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.example.projectIsa.users.model.enums.AllowedLogin;

@Entity
@DiscriminatorValue("FishingInstructor")
public class FishingInstructor extends User {

	private String explanation;
	
	private AllowedLogin allowLogin;

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public AllowedLogin getAllowLogin() {
		return allowLogin;
	}

	public void setAllowLogin(AllowedLogin allowLogin) {
		this.allowLogin = allowLogin;
	}
	
}
