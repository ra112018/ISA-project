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
public class Complaint {

	@Id
	@SequenceGenerator(name = "complaint_id_seq", sequenceName = "complaint_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complaint_id_seq")
    private Integer id;
	
    private String description;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Client client;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private RentingItem rentingItem;
    
    private boolean answered;

    
	public Complaint() {
		super();
	}

	public Complaint(Integer id, String description, Client client, RentingItem rentingItem,boolean answered) {
		super();
		this.id = id;
		this.description = description;
		this.client = client;
		this.rentingItem = rentingItem;
		this.answered = answered;
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

	public boolean isAnswered() {
		return answered;
	}

	public void setAnswered(boolean answered) {
		this.answered = answered;
	}
    
	
    
}
