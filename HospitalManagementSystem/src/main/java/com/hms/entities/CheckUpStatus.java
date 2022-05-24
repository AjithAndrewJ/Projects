package com.hms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CheckUpStatus {
	
	@Id
	@Column(name = "checkup_id")
	private long checkUpId;
	
	@Column(name = "doctor")
	private String drName;

	@Column(name = "patient")
    private String paName;
	
	@Column(name = "patient_illness")
	private String illness;
	
	@Column(name = "patient_status")
	@NotBlank(message = "inOrOutPatient should not be empty")
    private String inOrOutPatient;
	
	@OneToOne()
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
}
