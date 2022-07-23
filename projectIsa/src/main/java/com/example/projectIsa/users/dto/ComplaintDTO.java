package com.example.projectIsa.users.dto;

public class ComplaintDTO {

	private Integer clientId;
	
    private Integer rentingItemId;
    
    private String description;
    

	public ComplaintDTO() {
		super();
	}

	public ComplaintDTO(Integer clientId, Integer rentingItemId, String description) {
		super();
		this.clientId = clientId;
		this.rentingItemId = rentingItemId;
		this.description = description;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getRentingItemId() {
		return rentingItemId;
	}

	public void setRentingItemId(Integer rentingItemId) {
		this.rentingItemId = rentingItemId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
