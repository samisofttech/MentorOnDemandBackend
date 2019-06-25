package com.iiht.mentor.profile.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "MentorCal")
public class MentorCalender {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int mid;

	private Date start_date;

	private Date end_date;

	public MentorCalender(int id, @NotBlank int mid, @NotBlank Date start_date, @NotBlank Date end_date) {
		this.id = id;
		this.mid = mid;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	public MentorCalender() {
		
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

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

}
