package com.example.projectIsa.users.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Client")
public class Client extends User{

	
}
