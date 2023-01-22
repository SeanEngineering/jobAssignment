package io.nology.JobAssignment.jobs;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.nology.JobAssignment.temps.Temp;
import io.nology.JobAssignment.temps.TempRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class JobService {
	
	@Autowired
	private JobRepository repository;
	
	@Autowired
	private TempRepository tempRepository;
	
	public Job createJob(createJobDTO data) {
		Job newJob = new Job(data.getName(), data.getStartDate(), data.getEndDate());
		this.repository.save(newJob);
		return newJob;
		
	}
	
	public Optional<Job> findOne(long id){
		return this.repository.findById(id);
	}
	
	public Job updateJob(updateJobDTO data, long id) {
		Optional<Job> maybeJob = findOne(id);
		if (maybeJob.isEmpty()) {
			return null;
		}
		Job setJob = maybeJob.get();
		
		if (data.getName() != null) {
			setJob.setName(data.getName());
		}
		if (data.getStartDate() != null) {
			setJob.setName(data.getName());
		}
		if (data.getEndDate() != null) {
			setJob.setName(data.getName());
		}
		if (data.getTempId() != null) {
			Optional<Temp> maybeTemp = this.tempRepository.findById(data.getTempId());
			setJob.setTemp(maybeTemp.get());
			
		}
		
		this.repository.save(setJob);
		return setJob;
		
	}
	
	public List<Job> getJobs(){
		return this.repository.findAll();
		
	}
	
	public List<Job> assignedJobs(boolean assigned){
		List<Job> jobs = getJobs();
		if (assigned) {
			return jobs.stream().filter(item -> item.getTemp() != null).collect(Collectors.toList());
					
		}
		return jobs.stream().filter(item -> item.getTemp() == null).collect(Collectors.toList());
		
	}
	

}
