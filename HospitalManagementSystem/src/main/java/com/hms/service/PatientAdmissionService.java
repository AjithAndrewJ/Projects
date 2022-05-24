package com.hms.service;

import com.hms.entities.PatientAdmission;

public interface PatientAdmissionService {

	PatientAdmission savePatientAdmit(PatientAdmission pa,long id);
	
	PatientAdmission getPatientAdmitById(long id);
	
}
