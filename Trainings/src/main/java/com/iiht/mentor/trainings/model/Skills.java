package com.iiht.mentor.trainings.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "skills")
public class Skills {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	private String skillname;
	
	private String duration;
	
	private String prerequites;
	
	private long price;
	
	public Skills(String skillName) {
		this.skillname = skillName;
	}

	public Skills() {
		
	}

	
	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSkillname() {
		return skillname;
	}

	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}



	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPrerequites() {
		return prerequites;
	}

	public void setPrerequites(String prerequites) {
		this.prerequites = prerequites;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((skillname == null) ? 0 : skillname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skills other = (Skills) obj;
		if (skillname == null) {
			if (other.skillname != null)
				return false;
		} else if (!skillname.equals(other.skillname))
			return false;
		return true;
	}

	
	

}
