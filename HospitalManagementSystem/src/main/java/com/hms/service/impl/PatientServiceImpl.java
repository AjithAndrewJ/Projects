package com.hms.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.entities.Doctor;
import com.hms.entities.Patient;
import com.hms.exception.ResourceNotFoundException;
import com.hms.repositories.DoctorRepository;
import com.hms.repositories.PatientRepository;
import com.hms.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired 
	private PatientRepository patientRepository;
	
	@Autowired 
	private DoctorRepository doctorRepository;
	
	@Override
	public Patient savePatient(Patient p) {
		Optional<Patient> pat = patientRepository.findPatientContact(p);
		if(pat.isEmpty()){
			return patientRepository.save(p);
		}
		throw new ResourceNotFoundException(p.getPatientName()+" contact number is already exits!");
	}

	@Override 
	public Patient appointPatient(long drId,long pId) {
		Doctor dr=doctorRepository.findById(drId).orElseThrow(()->new ResourceNotFoundException("Doctor", "Id", drId));
		Patient p=patientRepository.findById(pId).orElseThrow(()->new ResourceNotFoundException("Patient", "Id", pId));
		int temp =dr.getPatientAttend();
			if(dr.getAvailableOrNot().equalsIgnoreCase("Available")) {
				if(temp<=2) {
					if(temp==2) {
						dr.setAvailableOrNot("Not Available");
						doctorRepository.save(dr);
					}	
						p.setDoctor(dr);	  
						temp++;
						dr.setPatientAttend(temp);
						return patientRepository.save(p);	
				}
			}
			throw new ResourceNotFoundException("Doctor "+dr.getDoctorName()+" is Not Available");
	}

	@Override
	public Patient getPatientById(long id) {
		return patientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Patient","Id", id));
	}

	@Override
	public Patient updatePatientById(Patient p, long id) {
		Patient existingPatient = patientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Patient","Id",id));
		  
		existingPatient.setPatientName(p.getPatientName());
		existingPatient.setPatientAge(p.getPatientAge());
		existingPatient.setGender(p.getGender());
		existingPatient.setBloodGroup(p.getBloodGroup());
		existingPatient.setPatientContact(p.getPatientContact());
		existingPatient.setPatientAddress(p.getPatientAddress());
		existingPatient.setAnyMajorDiseaseSufferedBefore(p.getAnyMajorDiseaseSufferedBefore());
		  
		patientRepository.save(existingPatient); 
		  return existingPatient;
	}

	@Override
	public String deletePatientById(long id) {
		Patient p =patientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Patient","Id",id));
        patientRepository.deleteById(id);
		return "Patient "+p.getPatientName()+" is deleted";
	}
	 
}
