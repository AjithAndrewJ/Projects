package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.entities.AdmissionPayment;
import com.hms.service.AdmissionPaymentService;

@RestController
public class AdmissionPaymentController {

	@Autowired
	private AdmissionPaymentService admissionPayementService;
	
	@PostMapping("/api/AdmisstionPay/{id}") 
	 public ResponseEntity<AdmissionPayment>saveAdmisstionPay(@RequestBody AdmissionPayment ap,@PathVariable("id") long id){
		 return new ResponseEntity<AdmissionPayment>(admissionPayementService.saveAdmisstionPay(ap,id),HttpStatus.CREATED); 
	 }
	
	@GetMapping("/api/getAdmissionPayById/{id}")
	  public ResponseEntity<AdmissionPayment>getAdmisstionPayById(@PathVariable("id")long id) { 
		  return new ResponseEntity<AdmissionPayment>(admissionPayementService.getAdmisstionPayById(id),HttpStatus.OK);
	  }
	
}
