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
@Table(name="pictures")
public class Picture {

	@Id
	@SequenceGenerator(name = "picture_entity_id_seq", sequenceName = "picture_entity_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "picture_entity_id_seq")
    @Column(name = "picture_id")
	private Integer id;
	

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fishing_adventure_id")
    private FishingAdventure adventure;
	
	private byte[] content;

	
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

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

}
