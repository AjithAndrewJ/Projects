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
public class PatientAdmission { 

	@Id
	private long patientAdmitId;
  
	@Column(name = "doctor_name")
    private String doctorName;
	
	@Column(name = "patient_name")
    private String patientName;
    
	@Column(name = "patient_illness")
	private String illness;
    
    @Column(name = "room_no")
    private int roomNo;
    
    @Column(name = "admission_date")
    @Temporal(TemporalType.DATE) 
    private Date admitDate =new Date();
    
    @OneToOne()
	@JoinColumn(name = "checkup_id")
	private CheckUpStatus checkUpStatus;
  
}