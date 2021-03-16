package com.simplilearn.controller;

import com.simplilearn.jdbc.JDBC_Manager;
import com.simplilearn.model.LearnersBean;

public class LearnerController {
	private JDBC_Manager jdbc_Manager;
	private LearnersBean learnersBean;
	
	public LearnerController(JDBC_Manager jdbc_Manager, LearnersBean learnersBean) {
		this.jdbc_Manager = jdbc_Manager;
		this.learnersBean = learnersBean;
	}
	
	public int getLearner_id() {
		return learnersBean.getLearner_id();
	}

	public void setLearner_id(int learner_id) {
		learnersBean.setLearner_id(learner_id);
	}

	public String getFirstName() {
		return learnersBean.getFirstName();
	}

	public void setFirstName(String firstName) {
		learnersBean.setFirstName(firstName);
	}

	public String getLastName() {
		return learnersBean.getLastName();
	}

	public void setLastName(String lastName) {
		learnersBean.setLastName(lastName); 
	}

	public String getAddress() {
		return learnersBean.getAddress();
	}

	public void setAddress(String address) {
		learnersBean.setAddress(address);
	}
	
	public void displayAllLearners() {
		jdbc_Manager.getAllLearnerRecords();
	}
	
	public void createNewLearner(LearnersBean learnersBean) {
		jdbc_Manager.addLearnersRuntime(learnersBean.getFirstName(), learnersBean.getLastName(), learnersBean.getAddress());
	}
	
	public void updateLearnerDetails(LearnersBean learnersBean) {
		jdbc_Manager.updateStudentsRuntime(learnersBean.getLearner_id(), learnersBean.getFirstName(), learnersBean.getLastName(), learnersBean.getAddress());
	}
	
	public void searchLearnerByAddress(String Address) {
		jdbc_Manager.getLearnerDetailsByAddress(Address);
	}
	
	public void searchLearnerByName(String firstName, String lastName) {
		jdbc_Manager.getLearnerDetailsByName(firstName, lastName);
	}
	
	public void sortLearner(String attribute) {
		jdbc_Manager.sortStudentsTable(attribute);
	}
	
	public void deleteLearner(int LearnerId) {
		jdbc_Manager.deleteLearnersRuntime(LearnerId);
	}

}
