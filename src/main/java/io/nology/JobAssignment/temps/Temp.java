package io.nology.JobAssignment.temps;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.nology.JobAssignment.jobs.Job;
import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Temp {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	Long id;
	
	@Column
	String firstName;
	
	@Column
	String lastName;
	
	public List<Temp> getManagedTemps() {
		return managedTemps;
	}

	public void setManagedTemps(List<Temp> managedTemps) {
		this.managedTemps = managedTemps;
	}

	public Temp getManager() {
		return manager;
	}

	public void setManager(Temp manager) {
		this.manager = manager;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "temp", orphanRemoval = true)
	@JsonIgnoreProperties({"temp"})
	@Nullable
	List<Job> jobs;
	
	@OneToMany(cascade = CascadeType.ALL)
	@Nullable
	List<Temp> managedTemps;
	
	@ManyToOne
	@Nullable
	@JoinColumn(name = "manager_id")
	Temp manager;
	
	
	public Temp() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public Temp(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobs = new ArrayList<>();
		this.managedTemps = null;
		this.manager = null;
	}

}
