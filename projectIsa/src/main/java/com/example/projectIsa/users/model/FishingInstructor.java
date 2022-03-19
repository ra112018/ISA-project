package com.example.projectIsa.users.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.example.projectIsa.users.model.enums.ActivationStatus;

@Entity
@DiscriminatorValue("FishingInstructor")
public class FishingInstructor extends User {

    private String explanation;

    private ActivationStatus activationStatus;
    
    public ActivationStatus getActivationStatus() {
        return activationStatus;
    }


    public void setActivationStatus(ActivationStatus activationStatus) {
        this.activationStatus = activationStatus;
    }


    public String getExplanation() {
        return explanation;
    }


    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

}
