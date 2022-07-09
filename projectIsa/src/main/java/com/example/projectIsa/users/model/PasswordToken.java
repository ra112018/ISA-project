package com.example.projectIsa.users.model;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "password_token")
public class PasswordToken {

	
	@Id
	@SequenceGenerator(name = "password_token_id_seq", sequenceName = "password_token_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "password_token_id_seq")
    @Column(name = "id")
	private Long id;
	
	private String token;
	
	private String email;
	
	private boolean activated = false;
	
	private Date expiryDate;
	
			
	public PasswordToken() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isActivated() {
		return activated;
	}


	public void setActivated(boolean activated) {
		this.activated = activated;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}


	public Date calculateExpiryDate(int expiryTimeInMinutes) {
	   Calendar cal = Calendar.getInstance();
	   cal.setTime(new Timestamp(cal.getTime().getTime()));
	   cal.add(Calendar.MINUTE, expiryTimeInMinutes);
	   return new Date(cal.getTime().getTime());
	}
}
