package com.mediscreendiabete.proxies;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mediscreendiabete.model.Patient;

@FeignClient(name = "mediscreen", url = "mediscreen:8081")
public interface MediscreenProxy {
	
	/**
     * Get all patients.
     * */
	@GetMapping(value = "/patients")
	List<Patient> getAllPatient();
	
	/**
	 * Gets patient by id
	 * @param idPatient
	 * @return the patient.
	 */
	@GetMapping(value = "/patientById")
	public ResponseEntity<com.mediscreendiabete.model.Response<Patient>>
 getPatientById(@RequestParam Integer patientId);
	
	/**
     * Gets the patient.
     *
     * @param firstName the first name,
     * @param lastName the last name
     * @return the patient
     */
	@GetMapping(value = "/patientByFirstAndLastName")
	public Optional<Patient> getPatientByFirstAndLastName(@RequestParam String firstName, @RequestParam String lastName);

}
