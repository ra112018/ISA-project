package com.example.projectIsa.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="equipment")
public class Equipment {
	
	@Id
	@SequenceGenerator(name = "equipment_entity_id_seq", sequenceName = "equipment_entity_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipment_entity_id_seq")
    @Column(name = "equipment_id")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fishing_adventure_id")
    private FishingAdventure adventure;
	
	private String name;
	
	private int price;
	
	private String information;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FishingAdventure getAdventure() {
		return adventure;
	}

	public void setAdventure(FishingAdventure adventure) {
		this.adventure = adventure;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}
}
