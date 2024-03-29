package com.iiht.mentor.trainings.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mentor")
public class Mentor {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="mentor_id")
    private int id;

	@NotBlank
    @Size(min=3, max = 50)
    private String username;
    
    private String linkedin;
    
    private int yearsExp;
    
    private boolean active;
    
    private int trainingsDelivered;
    
    private double fee;
    
    private int startTime;
    
    private int endTime;
    
    private double rating;


    @ManyToMany
    @JoinTable(name = "mentor_skills", 
    	joinColumns = @JoinColumn(name = "mentor_id"), 
    	inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skills> skills = new HashSet<>();

    public Mentor() {}

    public Mentor(String username, String linkedin, int yearsExp, int startTime, int endTime, double fee) {
        this.username = username;
        this.linkedin = linkedin;
        this.yearsExp = yearsExp;
        this.startTime = startTime;
        this.endTime = endTime;		
        this.fee = fee;
    }
    
	public Set<Skills> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skills> skills) {
		this.skills = skills;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public int getYearsExp() {
		return yearsExp;
	}

	public void setYearsExp(int yearsExp) {
		this.yearsExp = yearsExp;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public int getTrainingsDelivered() {
		return trainingsDelivered;
	}

	public void setTrainingsDelivered(int trainingsDelivered) {
		this.trainingsDelivered = trainingsDelivered;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	} 

}
