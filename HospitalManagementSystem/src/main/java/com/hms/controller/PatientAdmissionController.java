package com.hms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.entities.PatientAdmission;
import com.hms.service.PatientAdmissionService;

@RestController
public class PatientAdmissionController {

	@Autowired 
	private PatientAdmissionService patientAdmissionService;
	
	 @PostMapping("/api/PatientAdmit/{id}") 
	 public ResponseEntity<PatientAdmission>savePatientAdmit(@Valid @RequestBody PatientAdmission pa,@PathVariable("id") long id){
		 return new ResponseEntity<PatientAdmission>(patientAdmissionService.savePatientAdmit(pa,id),HttpStatus.CREATED);
	 }
	 @GetMapping("/api/getPatientAdmitById/{id}")
	  public ResponseEntity<PatientAdmission>getPatientAdmitById(@PathVariable("id")long id) { 
		  return new ResponseEntity<PatientAdmission>(patientAdmissionService.getPatientAdmitById(id),HttpStatus.OK);
	  }
	
}
