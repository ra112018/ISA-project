package com.example.projectIsa.users.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Administrator")
public class Administrator extends User {

}
