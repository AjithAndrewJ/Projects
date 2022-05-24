package com.hms.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "patient_id")
	private long patientId;
	
	@Column(name = "patient_name")
	@NotNull
	@Size(min = 2,message = "Patient Name should have atleast 2 character")
	private String patientName;
	
	@Column(name = "patient_age")
	@Min(1)
	private int patientAge;

	  @Column(name = "patient_gender")
	  @NotNull
	  @Size(min = 4,message = "Patient gender should be Male or Female") 
	  private String gender;
	  
	  @Column(name = "patient_blood_group")
	  @NotNull
	  @Size(max = 3,message = "Patient blood group ") 
	  private String bloodGroup;

	  @Column(name = "patient_contact")
	  @NotNull
	  @Pattern(regexp = "^\\d{10}$",message ="Phone number should have 10 digits")
	  private String patientContact;
	  
	  @Column(name = "registration_date")
	  @Temporal(TemporalType.DATE) 
	  private Date date=new Date();
	  
	  @Column(name = "patient_address")
	  @NotBlank(message = "Patient Address should not be empty") 
	  private String patientAddress;
	  
	  @Column(name = "patient_anyMajorDisease")	  
	  @NotBlank(message = "The Major Disease value should not be empty") 
	  private String anyMajorDiseaseSufferedBefore;
	
	  @ManyToOne(targetEntity = Doctor.class)  
	  @JoinColumn(name = "doctor_id") 
	  @JsonIgnoreProperties("patient")
	  private Doctor doctor;
	  
}