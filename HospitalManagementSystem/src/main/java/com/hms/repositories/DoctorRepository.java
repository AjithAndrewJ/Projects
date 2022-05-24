package com.hms.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hms.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	
	@Query("select d from Doctor d where d.doctorContact = :#{#contact.doctorContact}")
	Optional<Doctor> findDoctorContact(@Param("contact") Doctor contact);
	
}
