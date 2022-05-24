package com.hms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.entities.AdmissionPayment;

public interface AdmissionPaymentRepository extends JpaRepository<AdmissionPayment,Long>{

}
