package com.example.projectIsa.users.dto;

public class ClientDeleteAccountRequestReplyDTO {

	private Integer clientDeleteAccountRequestId;
	
    private String description;
    
    private Integer clientId;
    

	public ClientDeleteAccountRequestReplyDTO() {
		super();
	}

	public ClientDeleteAccountRequestReplyDTO(Integer clientDeleteAccountRequestId, String description,
			Integer clientId) {
		super();
		this.clientDeleteAccountRequestId = clientDeleteAccountRequestId;
		this.description = description;
		this.clientId = clientId;
	}

	public Integer getClientDeleteAccountRequestId() {
		return clientDeleteAccountRequestId;
	}

	public void setClientDeleteAccountRequestId(Integer clientDeleteAccountRequestId) {
		this.clientDeleteAccountRequestId = clientDeleteAccountRequestId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
    
    
}
