package com.example.projectIsa.users.dto;

public class OwnerDTO extends ClientDTO {
	
	private String role;
	private String explanation;
	

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
}
