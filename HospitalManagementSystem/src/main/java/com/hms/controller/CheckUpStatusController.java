package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.entities.CheckUpStatus;
import com.hms.service.CheckUpStatusService;

@RestController
public class CheckUpStatusController {
	
	@Autowired
	private CheckUpStatusService checkUpStatusService;
	
	 @PostMapping("/api/CheckUpStatus/{id}") 
	 public ResponseEntity<CheckUpStatus>savePatientStatus(@RequestBody CheckUpStatus cs,@PathVariable("id") long id){
		 return new ResponseEntity<CheckUpStatus>(checkUpStatusService.savePatientStatus(cs,id),HttpStatus.CREATED); 
	 }
	
	 @GetMapping("/api/getCheckUpStatusById/{id}")
	  public ResponseEntity<CheckUpStatus>getPatientStatusById(@PathVariable("id")long id) { 
		  return new ResponseEntity<CheckUpStatus>(checkUpStatusService.getPatientStatusById(id),HttpStatus.OK);
	  }
	 
}
