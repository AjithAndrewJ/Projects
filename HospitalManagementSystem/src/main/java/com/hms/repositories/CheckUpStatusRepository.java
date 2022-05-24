package com.hms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.entities.CheckUpStatus;

public interface CheckUpStatusRepository extends JpaRepository<CheckUpStatus, Long>{ 

}
