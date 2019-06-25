package com.iiht.mentor.profile.model;

public class MentorTrainingAvailablity {
	
	private String name;
	
	private int experience;
	
	private int noOfTrainingDeliverd;
	
	private long feeCharged;
	
	private String rating;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getNoOfTrainingDeliverd() {
		return noOfTrainingDeliverd;
	}

	public void setNoOfTrainingDeliverd(int noOfTrainingDeliverd) {
		this.noOfTrainingDeliverd = noOfTrainingDeliverd;
	}

	public long getFeeCharged() {
		return feeCharged;
	}

	public void setFeeCharged(long feeCharged) {
		this.feeCharged = feeCharged;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + experience;
		result = prime * result + (int) (feeCharged ^ (feeCharged >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + noOfTrainingDeliverd;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
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
		MentorTrainingAvailablity other = (MentorTrainingAvailablity) obj;
		if (experience != other.experience)
			return false;
		if (feeCharged != other.feeCharged)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (noOfTrainingDeliverd != other.noOfTrainingDeliverd)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		return true;
	}
	
	

}
