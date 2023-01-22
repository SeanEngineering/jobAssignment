package io.nology.JobAssignment.temps;

import io.nology.JobAssignment.jobs.Job;

public class CreateTempDTO {

	String firstName;
	String lastName;
	Job[] jobs = null;
	
	public CreateTempDTO(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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

	public Job[] getJobs() {
		return jobs;
	}

	public void setJobs(Job[] jobs) {
		this.jobs = jobs;
	}
	
	
	

}
