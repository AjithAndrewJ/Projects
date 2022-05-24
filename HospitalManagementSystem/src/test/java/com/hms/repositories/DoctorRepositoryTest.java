package com.hms.repositories;
  
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer; 
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test; 
import org.junit.jupiter.api.TestMethodOrder; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.hms.entities.Doctor; 
  
  @DataJpaTest
  //@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
  @TestMethodOrder(MethodOrderer.OrderAnnotation.class) 
  class DoctorRepositoryTest {

	  	@Autowired
	  	private DoctorRepository doctorRepository;

	  	@Autowired
	  	private TestEntityManager entityManager;

	  	@Test
	  	@Order(1)
	  	public void should_find_no_Doctor_if_repository_is_empty() {
	  		List<Doctor> docs = doctorRepository.findAll();
	  		assertThat(docs).isEmpty();
	  	}

	  	@Test
	  	@Order(2)
	  	public void should_store_a_doctor() {
	  		
	  		Doctor dr = new Doctor();
	  		dr.setDoctorId(1L);
	  		dr.setDoctorName("Ajith Andrew J");
	  		dr.setDoctorSpecialization("Heart Specialist");
	  		dr.setDoctorContact("2348711165");
	  		dr.setAvailableOrNot("avaliable");
	  		dr.setPatientAttend(0);

	  		assertThat(dr).hasFieldOrPropertyWithValue("doctorId", 1L);

	  		assertThat(dr).hasFieldOrPropertyWithValue("doctorSpecialization", "Heart Specialist");
	  		assertThat(dr).hasFieldOrPropertyWithValue("doctorContact", "2348711165");
	  		assertThat(dr).hasFieldOrPropertyWithValue("doctorName", "Ajith Andrew J");
	  		assertThat(dr).hasFieldOrPropertyWithValue("availableOrNot", "avaliable");
	  		assertThat(dr).hasFieldOrPropertyWithValue("patientAttend", 0);
	  		assertThat(dr).hasFieldOrPropertyWithValue("patient", null);
	  	}

	  	@Test
	  	@Order(3)
	  	public void should_find_all_doctors() {

	  		Doctor dr = new Doctor();

	  		dr.setDoctorName("John");
	  		dr.setDoctorSpecialization("Lungs Specialist");
	  		dr.setDoctorContact("7348711165");
	  		dr.setAvailableOrNot("avaliable");
	  		dr.setPatientAttend(0);
	  		entityManager.persist(dr);

	  		Doctor dr2 = new Doctor();
	  		dr2.setDoctorName("Mani");
	  		dr2.setDoctorSpecialization("General Physician");
	  		dr2.setDoctorContact("2348771185");
	  		dr2.setAvailableOrNot("avaliable");
	  		dr2.setPatientAttend(0);
	  		entityManager.persist(dr2);

	  		List<Doctor> tutorials = doctorRepository.findAll();
	  		assertThat(tutorials).hasSize(2).contains(dr, dr2);
	  	}

	  	@Test
	  	@Order(4)
	  	public void should_find_doctor_by_id() {

	  		Doctor dr = new Doctor();

	  		dr.setDoctorName("John");
	  		dr.setDoctorSpecialization("Lungs Specialist");
	  		dr.setDoctorContact("7348711165");
	  		dr.setAvailableOrNot("avaliable");
	  		dr.setPatientAttend(0);
	  		entityManager.persist(dr);

	  		Doctor foundDoctor = doctorRepository.findById(dr.getDoctorId()).get();
	  		assertThat(foundDoctor).isEqualTo(dr);
	  	}

	  	@Test
	  	@Order(5)
	  	public void should_update_doctor_by_id() {

	  		Doctor dr2 = new Doctor();
	  		dr2.setDoctorName("Anik Ghosh");
	  		dr2.setDoctorSpecialization("Kidney Specialist");
	  		dr2.setDoctorContact("9348711165");
	  		dr2.setAvailableOrNot("avaliable");
	  		dr2.setPatientAttend(10);
	  		doctorRepository.save(dr2);

	  		Doctor updated = new Doctor();
	  		updated.setDoctorName("Dr.Anik Ghosh");
	  		updated.setDoctorSpecialization("Kidney Specialist and Cure");
	  		updated.setDoctorContact("9348711165");
	  		updated.setAvailableOrNot("avaliable");
	  		updated.setPatientAttend(10);

	  		Doctor foundDoctor = doctorRepository.findById(dr2.getDoctorId()).get();

	  		foundDoctor.setDoctorName(updated.getDoctorName());
	  		foundDoctor.setDoctorSpecialization(updated.getDoctorSpecialization());
	  		foundDoctor.setDoctorContact(updated.getDoctorContact());
	  		foundDoctor.setAvailableOrNot(updated.getAvailableOrNot());
	  		foundDoctor.setPatientAttend(updated.getPatientAttend());

	  		doctorRepository.save(foundDoctor);
	  		Doctor checkDoc = doctorRepository.findById(foundDoctor.getDoctorId()).get();

	  		assertThat(checkDoc.getDoctorId()).isEqualTo(foundDoctor.getDoctorId());
	  		assertThat(checkDoc.getDoctorSpecialization()).isEqualTo(foundDoctor.getDoctorSpecialization());
	  		assertThat(checkDoc.getDoctorContact()).isEqualTo(foundDoctor.getDoctorContact());
	  	}

	  	@Test
	  	@Order(6)
	  	public void should_delete_doctor_by_id() {

	  		Doctor dr2 = new Doctor();
	  		dr2.setDoctorName("Anik Ghosh");
	  		dr2.setDoctorSpecialization("Kidney Specialist");
	  		dr2.setDoctorContact("9348711165");
	  		dr2.setAvailableOrNot("avaliable");
	  		dr2.setPatientAttend(10);

	  		entityManager.persist(dr2);
	  		Doctor dr3 = new Doctor();
	  		dr3.setDoctorName("Manik Ghosh");
	  		dr3.setDoctorSpecialization("All Specialist");
	  		dr3.setDoctorContact("6348711165");
	  		dr3.setAvailableOrNot("avaliable");
	  		dr3.setPatientAttend(8);

	  		entityManager.persist(dr3);

	  		doctorRepository.deleteById(dr3.getDoctorId());
	  		List<Doctor> listOfDoctor = doctorRepository.findAll();
	  		assertThat(listOfDoctor).hasSize(1).contains(dr2);
	  	}

	  	@Test
	  	@Order(7)
	  	public void should_delete_all_doctors() {
	  		Doctor dr2 = new Doctor();
	  		dr2.setDoctorName("Anik Ghosh");
	  		dr2.setDoctorSpecialization("Kidney Specialist");
	  		dr2.setDoctorContact("9348711165");
	  		dr2.setAvailableOrNot("avaliable");
	  		dr2.setPatientAttend(10);

	  		entityManager.persist(dr2);
	  		Doctor dr3 = new Doctor();
	  		dr3.setDoctorName("Manik Ghosh");
	  		dr3.setDoctorSpecialization("All Specialist");
	  		dr3.setDoctorContact("6348711165");
	  		dr3.setAvailableOrNot("avaliable");
	  		dr3.setPatientAttend(8);

	  		entityManager.persist(dr3);
	  		doctorRepository.deleteAll();
	  		assertThat(doctorRepository.findAll()).isEmpty();
	  	}

	  
  }