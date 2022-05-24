package com.hms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.entities.CheckUpStatus;
import com.hms.entities.PatientAdmission;
import com.hms.exception.ResourceNotFoundException;
import com.hms.repositories.CheckUpStatusRepository;
import com.hms.repositories.PatientAdmissionRepository;
import com.hms.service.PatientAdmissionService;

@Service
public class PatientAdmissionServiceImpl implements PatientAdmissionService{
	
	@Autowired
	private PatientAdmissionRepository patientAdmissionRepository;
	
	@Autowired
	private CheckUpStatusRepository checkUpStatusRepository;

	@Override
	public PatientAdmission savePatientAdmit(PatientAdmission pa, long id) {
		CheckUpStatus cs=checkUpStatusRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("CheckUpStatus", "Id", id));
		if(cs.getInOrOutPatient().equalsIgnoreCase("In") || cs.getInOrOutPatient().equalsIgnoreCase("In Patient") || cs.getInOrOutPatient().equalsIgnoreCase("In-Patient")) {
			pa.setPatientAdmitId(cs.getCheckUpId());
			pa.setDoctorName(cs.getDrName());
			pa.setIllness(cs.getIllness());
			pa.setPatientName(cs.getPaName());
			pa.setCheckUpStatus(cs);
			return patientAdmissionRepository.save(pa);
		}
		throw new ResourceNotFoundException("Patient "+cs.getPaName()+" is an Out-Patient");
	}

	@Override
	public PatientAdmission getPatientAdmitById(long id) {
		return patientAdmissionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("PatientAdmission","Id", id));
	}

}
