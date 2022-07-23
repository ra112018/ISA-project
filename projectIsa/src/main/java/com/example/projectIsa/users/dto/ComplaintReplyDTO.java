package com.example.projectIsa.users.dto;

public class ComplaintReplyDTO {
	
	private Integer complaintId;
	
	private Integer clientId;
	
    private Integer rentingItemId;
    
    private String description;
    

	public ComplaintReplyDTO() {
		super();
	}

	public ComplaintReplyDTO(Integer complaintId, Integer clientId, Integer rentingItemId, String description) {
		super();
		this.complaintId = complaintId;
		this.clientId = clientId;
		this.rentingItemId = rentingItemId;
		this.description = description;
	}

	public Integer getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(Integer complaintId) {
		this.complaintId = complaintId;
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
