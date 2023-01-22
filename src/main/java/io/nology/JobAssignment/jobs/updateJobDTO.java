package io.nology.JobAssignment.jobs;

import java.sql.Date;


public class updateJobDTO {
	 String name;
	 Date startDate;
	 Date endDate;
	 Long tempId;

	 public updateJobDTO(String name, Date startDate, Date endDate, Long tempId) {
		 this.name = name;
		 this.startDate = startDate;
		 this.endDate = endDate;
		 this.tempId = tempId;
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

	public Long getTempId() {
		return this.tempId;
	}

	public void setTempId(Long tempId) {
		this.tempId = tempId;
	}
	 
	 
}
