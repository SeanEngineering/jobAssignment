package io.nology.JobAssignment.jobs;

import java.sql.Date;

import io.nology.JobAssignment.temps.Temp;

public class createJobDTO {
	String name;
	Date startDate;
	Date endDate; 
	Temp[] temp = null;
	
	public createJobDTO(String name, Date startDate, Date endDate) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Temp[] getTemp() {
		return temp;
	}
	public void setTemp(Temp[] temp) {
		this.temp = temp;
	}
	
	
	
}
