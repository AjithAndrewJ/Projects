package com.hms.service;

import com.hms.entities.GeneralPayment;

public interface GeneralPaymentService {
	
	GeneralPayment saveGeneralPayment(GeneralPayment gp,long id);

	GeneralPayment getGeneralPaymentById(long id);
	
}
