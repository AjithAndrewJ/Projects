package com.hms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.entities.Patient;
import com.hms.service.PatientService;

@RestController
public class PatientController {
	
	 @Autowired 
	 private PatientService patientService;
	
	 @PostMapping("/api/savePatient")
	 public ResponseEntity<Patient>savePatient(@Valid @RequestBody Patient p){
		 return new ResponseEntity<Patient>(patientService.savePatient(p),HttpStatus.CREATED);
	 }
	 
	 @PostMapping("/api/appointPatient/{drId}/{pId}")
	 public ResponseEntity<Patient>appointPatient(@PathVariable("drId") long drId,@PathVariable("pId") long pId){
		 return new ResponseEntity<Patient>(patientService.appointPatient(drId,pId),HttpStatus.CREATED);
	 }
	 
	 
	 @GetMapping("/api/getPatientById/{id}")
	  public ResponseEntity<Patient>getPatientById(@PathVariable("id")long id) { 
		  return new ResponseEntity<Patient>(patientService.getPatientById(id),HttpStatus.OK);
	  }
	  
	 @PutMapping("/api/updatePatientById/{id}")
	  public ResponseEntity<Patient>updatePatient(@Valid @RequestBody Patient p,@PathVariable("id") long id){
		  return new ResponseEntity<Patient>(patientService.updatePatientById(p,id),HttpStatus.OK);
	  }
	 
}
