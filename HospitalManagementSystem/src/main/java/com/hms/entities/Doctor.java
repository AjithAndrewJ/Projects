package com.hms.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "doctor_id")
	private long doctorId;
	
	@Column(name = "doctor_name")
	@NotNull
	@Size(min = 3,message = "Doctor Name should have atleast 2 character")
	private String doctorName;
	
	@Column(name = "doctor_specialization")
	@NotNull
	@Size(min = 3,message = "Specialization Name should have atleast 2 character")
	private String doctorSpecialization;
	
	@Column(name = "doctor_contact")
	@NotNull
	@Pattern(regexp = "^\\d{10}$",message = "Phone number should have 10 digits")
	private String doctorContact;
	
	@Column(name = "doctor_AvailableOrNot")
	private String availableOrNot="Available";
	
	@Column(name = "patient_attend_for_today")
	private int patientAttend=0;
	
	@OneToMany(mappedBy = "doctor")
	@JsonIgnoreProperties("doctor")
	private List<Patient> patient;
	
}