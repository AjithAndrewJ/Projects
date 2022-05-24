package com.hms.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.entities.Doctor;
import com.hms.service.DoctorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class DoctorController {
	
	  @Autowired 
	  private DoctorService doctorService;
	  
	  @PostMapping("/api/saveDoctor") 
	  public ResponseEntity<Doctor>saveDr(@Valid @RequestBody Doctor dr){ 
		  return new ResponseEntity<Doctor>(doctorService.saveDr(dr),HttpStatus.CREATED); 
	  }
	  
	
	  @GetMapping("/api/getAllDoctors")
	  public List<Doctor> getAllDr() {
		  return doctorService.getAllDr(); 
	  }
	  
	  @GetMapping("/api/getDoctorById/{id}")
	  public ResponseEntity<Doctor>getDoctorById(@PathVariable("id")long DoctorId) { 
		  return new ResponseEntity<Doctor>(doctorService.getDrById(DoctorId),HttpStatus.OK);
	  }
	  
	  @PutMapping("/api/updateDoctorById/{id}")
	  public ResponseEntity<Doctor>updateDoctor(@Valid @RequestBody Doctor dr,@PathVariable("id") long id){
		  return new ResponseEntity<Doctor>(doctorService.updateDrById(dr,id),HttpStatus.OK);
	  }
	  
}