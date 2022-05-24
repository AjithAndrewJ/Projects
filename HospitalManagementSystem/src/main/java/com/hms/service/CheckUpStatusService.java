package com.hms.service;

import com.hms.entities.CheckUpStatus;

public interface CheckUpStatusService {
	
	CheckUpStatus savePatientStatus(CheckUpStatus checkUpStatus,long id);
	
	CheckUpStatus getPatientStatusById(long id);
	
}
