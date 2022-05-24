package com.hms.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hms.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	@Query("select p from Patient p where p.patientContact = :#{#contact.patientContact}")
	Optional<Patient> findPatientContact(@Param("contact") Patient contact);
	
}
