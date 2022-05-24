package com.hms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.entities.CheckUpStatus;
import com.hms.entities.Patient;
import com.hms.exception.ResourceNotFoundException;
import com.hms.repositories.CheckUpStatusRepository;
import com.hms.repositories.PatientRepository;
import com.hms.service.CheckUpStatusService;

@Service
public class CheckUpStatusServiceImpl implements CheckUpStatusService{
	
	@Autowired
	private CheckUpStatusRepository checkUpStatusRepository;
	
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public CheckUpStatus savePatientStatus(CheckUpStatus checkUpStatus,long id) {
		Patient pa=patientRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Patient", "Id", id));
		checkUpStatus.setCheckUpId(pa.getPatientId());
		checkUpStatus.setDrName(pa.getDoctor().getDoctorName());
		checkUpStatus.setPaName(pa.getPatientName());
		checkUpStatus.setPatient(pa);
		return checkUpStatusRepository.save(checkUpStatus);
	}

	@Override
	public CheckUpStatus getPatientStatusById(long id) {
		return checkUpStatusRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("CheckUpStatus","Id", id));
	}
	
}
