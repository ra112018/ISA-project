package com.example.projectIsa.users.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class DeleteAccountRequest {

	@Id
	@SequenceGenerator(name = "delete_client_account_id_seq", sequenceName = "delete_client_account_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delete_client_account_id_seq")
    private Integer id;
	
    private String description;
    
    private boolean approved;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Client client;
    

	public DeleteAccountRequest() {
		super();
	}


	public DeleteAccountRequest(Integer id, String description, boolean approved, Client client) {
		super();
		this.id = id;
		this.description = description;
		this.approved = approved;
		this.client = client;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isApproved() {
		return approved;
	}


	public void setApproved(boolean approved) {
		this.approved = approved;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}
    
    
}
