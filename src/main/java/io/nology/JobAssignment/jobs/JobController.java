package io.nology.JobAssignment.jobs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/jobs")
public class JobController {
	@Autowired
	private JobService service;
	
	@PostMapping
	public ResponseEntity<Job> createJob(@Valid @RequestBody createJobDTO data) {
		Job createdJob = this.service.createJob(data);
		return new ResponseEntity<Job>(createdJob, HttpStatus.CREATED);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Job> updateJob(@Valid @RequestBody updateJobDTO data, @PathVariable Long id){
		Job updatedJob = this.service.updateJob(data, id);
		return new ResponseEntity<Job>(updatedJob, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Job>> getJob(@PathVariable Long id){
		Optional<Job> maybeJob = this.service.findOne(id);
		if (maybeJob.isPresent()) {
			return new ResponseEntity<Optional<Job>>(maybeJob, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Job>> getJobs(@RequestParam(required = false) Boolean assigned, HttpServletRequest request){
		String isAssigned = request.getParameter("assigned");
		if (isAssigned == null) {
			return new ResponseEntity<List<Job>>(this.service.getJobs(), HttpStatus.OK);
		}
		List<Job> filteredByAssignedJobs = this.service.assignedJobs(assigned);
		return new ResponseEntity<List<Job>>(filteredByAssignedJobs, HttpStatus.ACCEPTED);
	}

	
	

}
