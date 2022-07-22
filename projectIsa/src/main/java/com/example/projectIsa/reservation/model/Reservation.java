package com.example.projectIsa.reservation.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.projectIsa.renting.model.RentingItem;
import com.example.projectIsa.users.model.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="reservations")
public class Reservation {

	@Id
	@SequenceGenerator(name = "reservations_id_seq", sequenceName = "reservations_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservations_id_seq")
	private Integer id;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Client client;
    
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private RentingItem rentingItem;
    
    private Date startTime;
    
    private Date endTime;
    
    private double price;
    
    /*
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
    name = "reservation_additionalServices",
    joinColumns = { @JoinColumn(name = "reservation_id") },
    inverseJoinColumns = { @JoinColumn(name = "additional_service_id") }
    )
    private List<AdditionalService> additionalServices;
    */
    
    private boolean cancelled;
    

	public Reservation() {
		super();
	}


	public Reservation(Integer id, Client client, RentingItem rentingItem, Date startTime, Date endTime, double price,
			boolean cancelled) {
		super();
		this.id = id;
		this.client = client;
		this.rentingItem = rentingItem;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
		this.cancelled = cancelled;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public Date getEndTime() {
		return endTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public boolean isCancelled() {
		return cancelled;
	}


	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}
    
	
    
}
