package com.example.projectIsa.users.dto;

public class RegistrationRequestDTO {
	
	String email;
	String name;
	String surname;
	String role;
	String explanation;

	public RegistrationRequestDTO(String email, String name, String surname, String role, String explanation) {
		// TODO Auto-generated constructor stub
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.explanation = explanation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

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
