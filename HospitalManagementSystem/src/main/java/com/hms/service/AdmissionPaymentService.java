package com.hms.service;

import com.hms.entities.AdmissionPayment;

public interface AdmissionPaymentService {

	AdmissionPayment saveAdmisstionPay(AdmissionPayment ap,long id);
	
	AdmissionPayment getAdmisstionPayById(long id);
	
}
