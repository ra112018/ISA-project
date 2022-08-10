package com.example.projectIsa.users.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.example.projectIsa.users.model.enums.AllowedLogin;

@Entity
@DiscriminatorValue("CottageOwner")
public class CottageOwner extends User{

	private String explanationCO;

	private AllowedLogin allowLoginCO;

	public String getExplanationCO() {
		return explanationCO;
	}

	public void setExplanationCO(String explanationBO) {
		this.explanationCO = explanationCO;
	}

	public AllowedLogin getAllowLoginCO() {
		return allowLoginCO;
	}

	public void setAllowLoginCO(AllowedLogin allowLoginCO) {
		this.allowLoginCO = allowLoginCO;
	}
	
}
