package com.electricity_demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.electricity_demo.entity.ElecReading;
import com.electricity_demo.exception.NoSuchCustomerException;
import com.electricity_demo.service.ElecReadingServiceImpl;

@RestController

public class ElecReadingController {
	
	@Autowired
	private ElecReadingServiceImpl elecReadingServices;
	
	@GetMapping("/ElecReading")
	public ResponseEntity<List<ElecReading>> allElecreading() {
		List<ElecReading> allElecreading=elecReadingServices.allElecreading();
		return new ResponseEntity<List<ElecReading>>(allElecreading,HttpStatus.OK);
	}
	
	@GetMapping("/ElecReading/{readingId}")
	public ResponseEntity<Optional<ElecReading>> getElecReadingById(@RequestBody ElecReading elecreading,@PathVariable long readingId){
		elecreading.setReadingId(readingId);
		Optional<ElecReading> getElecReadingById=elecReadingServices.getElecReadingById(readingId);
		return new ResponseEntity<Optional<ElecReading>>(getElecReadingById,HttpStatus.OK);
	}
	
	@PostMapping("/ElecReading")
	public ResponseEntity<ElecReading> saveElecReading(@RequestBody @Valid ElecReading elecreading) {
		ElecReading saveElecReading=elecReadingServices.saveElecReading(elecreading);
		return new ResponseEntity<ElecReading>(saveElecReading,HttpStatus.CREATED);
	}
	
	@PutMapping("/ElecReading/{readingId}")
	public ResponseEntity<ElecReading> addElecReading(@RequestBody ElecReading elecreading,@PathVariable long readingId) {
		elecreading.setReadingId(readingId);
		ElecReading addElecReading=elecReadingServices.addElecReading(elecreading);
		return new ResponseEntity<ElecReading>(addElecReading,HttpStatus.OK);
	}
	

	@DeleteMapping("/ElecReading/{readingId}") 
	public String deleteElecReading(@PathVariable("readingId") Long readingId) throws NoSuchCustomerException
	{ 
		 elecReadingServices.deleteElecReading(readingId);
	      return "deleted Successfully";
	}  
	

}
