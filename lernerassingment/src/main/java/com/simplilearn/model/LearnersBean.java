package com.simplilearn.model;

public class LearnersBean {
	private int learner_id;
	private String firstName;
	private String lastName;
	private String address;
	
	public LearnersBean() {
		
	}

	public LearnersBean(int learner_id, String firstName, String lastName, String address) {
		this.learner_id = learner_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	public int getLearner_id() {
		return learner_id;
	}

	public void setLearner_id(int learner_id) {
		this.learner_id = learner_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Learners [learner_id=" + learner_id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + "]";
	}

}
