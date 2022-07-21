package com.example.projectIsa.users.dto;

public class ClientDeleteAccountRequestDTO {
	
	private Integer clientId;
	
    private String description;
    

	public ClientDeleteAccountRequestDTO() {
		super();
	}

	public ClientDeleteAccountRequestDTO(Integer clientId, String description) {
		super();
		this.clientId = clientId;
		this.description = description;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
