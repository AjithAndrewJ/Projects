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

import com.hms.entities.GeneralPayment;
import com.hms.service.GeneralPaymentService;

@RestController
public class GeneralPaymentController {
	
	@Autowired
	private GeneralPaymentService generalPaymentService;

	@PostMapping("/api/GeneralPayment/{id}") 
	 public ResponseEntity<GeneralPayment>saveGeneralPayment(@Valid @RequestBody GeneralPayment gp,@PathVariable("id") long id){
		 return new ResponseEntity<GeneralPayment>(generalPaymentService.saveGeneralPayment(gp,id),HttpStatus.CREATED);
	 }
	
	@GetMapping("/api/getGeneralPaymentById/{id}")
	  public ResponseEntity<GeneralPayment>getGeneralPaymentById(@PathVariable("id")long id) { 
		  return new ResponseEntity<GeneralPayment>(generalPaymentService.getGeneralPaymentById(id),HttpStatus.OK);
	  }

}
