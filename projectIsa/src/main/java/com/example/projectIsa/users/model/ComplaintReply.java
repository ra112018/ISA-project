package com.example.projectIsa.users.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.example.projectIsa.renting.model.RentingItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class ComplaintReply {

	@Id
	@SequenceGenerator(name = "complaint_reply_id_seq", sequenceName = "complaint_reply_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complaint_reply_id_seq")
    private Integer id;
	
    private String description;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Client client;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private RentingItem rentingItem;

    
	public ComplaintReply() {
		super();
	}

	public ComplaintReply(Integer id, String description, Client client, RentingItem rentingItem) {
		super();
		this.id = id;
		this.description = description;
		this.client = client;
		this.rentingItem = rentingItem;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public RentingItem getRentingItem() {
		return rentingItem;
	}

	public void setRentingItem(RentingItem rentingItem) {
		this.rentingItem = rentingItem;
	}
}
