package com.iiht.mentor.profile.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "MentorSkill")
public class MentorSkill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int mid;

	private int sid;

	private String self_rating;

	private int years_of_exp;

	@NotBlank
	private String trainings_delivered;

	private String facilities_offered;

	public MentorSkill(int id, @NotBlank int mid, @NotBlank int sid, String self_rating,
			@NotBlank Integer years_of_exp, @NotBlank String trainings_delivered, String facilities_offered) {
		this.id = id;
		this.mid = mid;
		this.sid = sid;
		this.self_rating = self_rating;
		this.years_of_exp = years_of_exp;
		this.trainings_delivered = trainings_delivered;
		this.facilities_offered = facilities_offered;
	}
	public MentorSkill() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSelf_rating() {
		return self_rating;
	}

	public void setSelf_rating(String self_rating) {
		this.self_rating = self_rating;
	}

	public Integer getYears_of_exp() {
		return years_of_exp;
	}

	public void setYears_of_exp(Integer years_of_exp) {
		this.years_of_exp = years_of_exp;
	}

	public String getTrainings_delivered() {
		return trainings_delivered;
	}

	public void setTrainings_delivered(String trainings_delivered) {
		this.trainings_delivered = trainings_delivered;
	}

	public String getFacilities_offered() {
		return facilities_offered;
	}

	public void setFacilities_offered(String facilities_offered) {
		this.facilities_offered = facilities_offered;
	}

}
