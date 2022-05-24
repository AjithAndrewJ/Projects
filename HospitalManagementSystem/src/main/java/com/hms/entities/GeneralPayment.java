package com.hms.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class GeneralPayment {

	@Id
	@Column(name = "generalpay")
	private long generalPayId;
	
	@Column(name = "patient_name")
	private String patientName;
	
	@Column(name = "patient_illness")
	private String illness;
	
	@Column(name = "consultation_fee")
	@Min(1)
	private double consultationFee;
	
	@Column(name = "payment_mode")
	@NotBlank(message = "paymentMode should not be empty")
	private String paymentMode;
	
	@Column(name = "payment_date")
	@Temporal(TemporalType.DATE)
	private Date date =new Date();
	
	@OneToOne()
	@JoinColumn(name = "checkup_id")
	private CheckUpStatus checkUpStatus;
	
}