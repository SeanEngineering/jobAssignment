package io.nology.JobAssignment.temps;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.nology.JobAssignment.jobs.Job;
import io.nology.JobAssignment.jobs.JobService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class TempService {
	
	@Autowired
	private JobService jobService;

	@Autowired 
	private TempRepository repository;
	
	public Temp createTemp(CreateTempDTO data) {
		Temp newTemp = new Temp(data.getFirstName(), data.getLastName());
		this.repository.save(newTemp);
		return newTemp;
		
	}
	
	public List<Temp> getTemps(){
		return this.repository.findAll();
	}
	
	public Optional<Temp> getTempById(long id) {
		Optional<Temp> maybeTemp = this.repository.findById(id);
		if (maybeTemp.isEmpty()) {
			return null;
		}
		return maybeTemp;
	}
	
	public List<Temp> getAvailableTemps(long jobId){
		List<Temp> temps = getTemps();
		List<Job> jobList = this.jobService.getJobs();
		List<Job> badJobs = new ArrayList<>();
		Optional<Job> maybeJob = this.jobService.findOne(jobId);
		if (maybeJob.isEmpty()) {
			return null;
		} 
		Date startDate = maybeJob.get().getStartDate();
		Date endDate = maybeJob.get().getEndDate();
		for (Job job: jobList) {
			if (endDate.compareTo(job.getStartDate()) < 0 || startDate.compareTo(job.getEndDate()) < 0 || (startDate.compareTo(job.getStartDate()) > 0 && endDate.compareTo(job.getStartDate()) > 0)) {
				badJobs.add(job);

			}
		}
		
		for (Job job: badJobs) {
			temps = temps.stream().filter(temp -> !temp.getJobs().contains(job)).collect(Collectors.toList());
		}
		return temps;
		
	}
}
