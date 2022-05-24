package com.hms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.entities.AdmissionPayment;
import com.hms.entities.PatientAdmission;
import com.hms.exception.ResourceNotFoundException;
import com.hms.repositories.AdmissionPaymentRepository;
import com.hms.repositories.PatientAdmissionRepository;
import com.hms.service.AdmissionPaymentService;

@Service
public class AdmissionPaymentServiceImpl implements AdmissionPaymentService{
	
	@Autowired
	private AdmissionPaymentRepository admissionPayementRepository;
	
	@Autowired
	private PatientAdmissionRepository patientAdmissionRepository;

	@Override
	public AdmissionPayment saveAdmisstionPay(AdmissionPayment ap, long id) {
		double totalRoomCharges=ap.getNoOfDays()*ap.getRoomCharges();
		double totalCharges=totalRoomCharges+ap.getServiceCharges()+ap.getDoctorFee();
		PatientAdmission pa=patientAdmissionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AdmissionPayement", "Id", id));
		ap.setAdmissionPayId(pa.getPatientAdmitId());
		ap.setIllness(pa.getIllness());
		ap.setTotalRoomCharges(totalRoomCharges);
		ap.setTotalCharges(totalCharges);
		ap.setPatientAdmission(pa);
		return admissionPayementRepository.save(ap);
	}

	@Override
	public AdmissionPayment getAdmisstionPayById(long id) {
		return admissionPayementRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AdmissionPayment", "Id", id));
	}

}
