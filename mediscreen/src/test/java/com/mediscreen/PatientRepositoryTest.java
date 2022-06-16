package com.mediscreen;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

import com.mediscreen.exception.PatientDuplicateException;
import com.mediscreen.model.Patient;
import com.mediscreen.model.Response;
import com.mediscreen.repository.PatientRepository;
import com.mediscreen.service.PatientServiceImpl;

@SpringBootTest
@TestPropertySource("/applicationTest.properties")
@Transactional
@DirtiesContext
public class PatientRepositoryTest {
	
	final Logger logger = LogManager.getLogger(PatientRepositoryTest.class);
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	PatientServiceImpl patientService;
	
	@BeforeEach
    public void setup() {
		savePatients(); 
    }
	
	@AfterEach
    public void emptyTables() {
		patientRepository.deleteAll(); 
		
		
    }

	// JUnit test for savePatient
	@Test
	public void save_newPatientTest_PatientSavedInListOfPatients() throws PatientDuplicateException {
		
		String dateString = "1999-06-13";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 
		Patient patient = new Patient();
		patient.setFirstName("Ramesh");
		patient.setLastName("Sadou");
		patient.setBirthDate(LocalDate.parse(dateString, formatter));
		patient.setSex("M");
		patient.setAddress("6 rue lamartine 75009 Paris");
		patient.setPhone("0603367020");
		
		patientService.savePatient(patient);
		
		
		Assertions.assertThat(patient.getFirstName().equalsIgnoreCase("Ramesh"));
	}
	
	@Test
	public void findAllPatientsTest_ListOfPatients() {
		//Arrange
		String firstName = "Geremy";
		//Act
		List<Patient> lPatients = patientService.getPatients();
		
		assertNotEquals(Collections.EMPTY_LIST, lPatients.size());
		assertTrue(lPatients.stream().anyMatch(p -> firstName.equals(p.getFirstName())));
	}
	
	@Test
	public void savePatientsTest_ListOfPatientsCreated() {
		
		//Act
		List<Patient> lPatients = patientRepository.findAll();
		
		assertNotEquals(Collections.EMPTY_LIST, lPatients);
		assertEquals(3, lPatients.size());
	}

	

	// JUnit test for updatePatient
	@Test
	public void update_existingPatientTest_PatientUpdatedInListOfPatients() {
		logger.debug("Calling update patient");
		
		ResponseEntity<Response> response  = patientService.getPatientById(3);
		
		String dateString = "1999-06-13";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 
		Patient existingPatient = (Patient)response.getBody().getData();
		existingPatient.setFirstName("Ramesh");
		existingPatient.setLastName("Dupuis");
		existingPatient.setBirthDate(LocalDate.parse(dateString, formatter));
		existingPatient.setSex("M");
		existingPatient.setAddress("6 rue lamartine 75009 Paris");
		existingPatient.setPhone("0603367020");
		logger.error("Calling update patient");
		ResponseEntity<Response> patientResult = patientService.updatePatient(existingPatient);
		
		Patient updatedPatient = (Patient)patientResult.getBody().getData();
		Assertions.assertThat(updatedPatient.getFirstName().equalsIgnoreCase("Ramesh"));
	}
	
	// JUnit test for getPatientById
	@Test
	public void getPatientByFirstAndLastname_existingPatientTest_PatientFound() {
		
		Optional<Patient> patient = patientService.getPatientByFirstNameAndLastName("Clara", "Lopes");
		
		assertNotNull(patientService.getPatientByFirstNameAndLastName("Clara", "Lopes").get());
	}
	
	@Test
	public void getPatientByIdTest_existingPatientTest_PatientFound() {
		
		ResponseEntity<Response> response =  patientService.getPatientById(2);
		Patient patient = (Patient)response.getBody().getData();
		
		Optional<Patient> patientById = patientRepository.findById(2);
		
		assertTrue(patient.equals(patientById.get()));
	}
		
	private void savePatients() {
		String dateString1 = "2008-06-19";
		String dateString2 = "2010-07-03";
		String dateString3 = "2012-09-25";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		Patient patient1 = new Patient();
		patient1.setFirstName("Geremy");
		patient1.setLastName("Lopes");
		patient1.setBirthDate(LocalDate.parse(dateString1, formatter));
		patient1.setSex("M");
		patient1.setAddress("31 rue Dominique 75007 Paris");
		patient1.setPhone("0603367001");
		
		Patient patient2 = new Patient();
		patient2.setFirstName("Clara");
		patient2.setLastName("Lopes");
		patient2.setBirthDate(LocalDate.parse(dateString2, formatter));
		patient2.setSex("M");
		patient2.setAddress("31 rue Dominique 75007 Paris");
		patient2.setPhone("0603367002");
		
		Patient patient3 = new Patient();
		patient3.setFirstName("Alex");
		patient3.setLastName("Lopes");
		patient3.setBirthDate(LocalDate.parse(dateString3, formatter));
		patient3.setSex("M");
		patient3.setAddress("31 rue Dominique 75007 Paris");
		patient3.setPhone("0603367003");
		
		List<Patient> patients = new ArrayList<>();
		patients.add(patient1);
		patients.add(patient2);
		patients.add(patient3);
		
		patientRepository.saveAll(patients);
	}
}
