package com.hms.service;

import com.hms.entities.Patient;

public interface PatientService {
	
	Patient savePatient(Patient p);
	
	 Patient appointPatient(long drId,long pId);
	 
	 Patient getPatientById(long id);

	Patient updatePatientById(Patient p, long id);

	String deletePatientById(long id);

}
