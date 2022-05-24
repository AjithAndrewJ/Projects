package com.hms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.entities.CheckUpStatus;
import com.hms.entities.GeneralPayment;
import com.hms.exception.ResourceNotFoundException;
import com.hms.repositories.CheckUpStatusRepository;
import com.hms.repositories.GeneralPaymentRepository;
import com.hms.service.GeneralPaymentService;

@Service
public class GeneralPaymentServiceImpl implements GeneralPaymentService{
	
	@Autowired
	private GeneralPaymentRepository generalPaymentRepositiory;
	
	@Autowired
	private CheckUpStatusRepository checkUpStatusRepository;
	
	@Override
	public GeneralPayment saveGeneralPayment(GeneralPayment gp,long id) {
		CheckUpStatus cs=checkUpStatusRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("CheckUpStatus", "Id", id));
		if(cs.getInOrOutPatient().equalsIgnoreCase("Out") || cs.getInOrOutPatient().equalsIgnoreCase("Out Patient") || cs.getInOrOutPatient().equalsIgnoreCase("Out-Patient")) {
			gp.setGeneralPayId(cs.getCheckUpId());
			gp.setPatientName(cs.getPaName());
			gp.setIllness(cs.getIllness());
			gp.setCheckUpStatus(cs);
			return generalPaymentRepositiory.save(gp);
		}
		throw new ResourceNotFoundException("Patient "+cs.getPaName()+" is an In-Patient");
	}

	@Override
	public GeneralPayment getGeneralPaymentById(long id) {
		return generalPaymentRepositiory.findById(id).orElseThrow(()-> new ResourceNotFoundException("GeneralPayment", "id", id));
	}

}
