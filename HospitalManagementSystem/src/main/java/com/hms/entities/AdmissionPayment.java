package com.hms.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor; 
import lombok.Data; 
import lombok.NoArgsConstructor;
  
@AllArgsConstructor
@NoArgsConstructor
@Data 
@Entity 
public class AdmissionPayment {
	
	@Id
	private long admissionPayId;
	
	@Column(name = "patient_illness")
	private String illness;
  
	@Column(name = "room_charges")
	private double roomCharges;
	  
	@Column(name = "no_of_days")
	private int noOfDays;
	  
	@Column(name = "total_room_charges")
	private double totalRoomCharges;
	  
	@Column(name = "service_charges")
	private double serviceCharges;
	  
	@Column(name = "doctor_fee")
	private double doctorFee;
	  
	@Column(name = "payment_mode")
	private String paymentMode;
	
	@Column(name = "discharge_date")
    @Temporal(TemporalType.DATE) 
    private Date dischargeDate =new Date();
	  
	@Column(name = "total_charges")
	private double totalCharges;
	
	@OneToOne()
	@JoinColumn(name = "patient_admission")
	private PatientAdmission patientAdmission;
  
}
 