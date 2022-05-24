package com.hms.service;

import java.util.List;

import com.hms.entities.Doctor;

public interface DoctorService {
	
	  Doctor saveDr(Doctor dr);
	  
		
		  List<Doctor> getAllDr();
		  
		  Doctor getDrById(long id);
		  
		  Doctor updateDrById(Doctor dr,long id);
		  
		  String deleteDrById(long id);

}
