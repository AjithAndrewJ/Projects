package com.hms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.entities.PatientAdmission;

public interface PatientAdmissionRepository extends JpaRepository<PatientAdmission,Long>{

}
