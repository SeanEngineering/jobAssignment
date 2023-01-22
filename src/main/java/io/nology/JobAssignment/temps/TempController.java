package io.nology.JobAssignment.temps;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/temps")
public class TempController {
	@Autowired
	private TempService service;
	
	@GetMapping
	public ResponseEntity<List<Temp>> getTemps(@RequestParam(required = false) Long jobId, HttpServletRequest request){
		String thisJob = request.getParameter("jobId");
		System.out.println(thisJob);
		if (thisJob == null) {
			List<Temp> temps = this.service.getTemps();
			return new ResponseEntity<List<Temp>>(temps, HttpStatus.OK);
		}
		List<Temp> temps = this.service.getAvailableTemps(Long.parseLong(thisJob));
		
		return new ResponseEntity<List<Temp>>(temps, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Temp>> getTemp(@PathVariable long id){
		Optional<Temp> maybeTemp = this.service.getTempById(id);
		return new ResponseEntity<Optional<Temp>>(maybeTemp, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Temp> createTemp(@Valid @RequestBody CreateTempDTO data){
		Temp newTemp = this.service.createTemp(data);
		return new ResponseEntity<Temp>(newTemp, HttpStatus.CREATED);
	}


}
