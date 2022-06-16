package com.mediscreendiabete.service;

import java.util.Optional;

import com.mediscreendiabete.model.DiabeteAssess;
import com.mediscreendiabete.model.Patient;

public interface IAssessment {
	
	/**
	 * 
	 * @param patientId
	 * @return the patient assessment
	 */
	DiabeteAssess getdiabeteAssess(int patientId);
	
	public Optional<Patient> getPatient(String firstName, String lastName);
	
	//String assessPatientHealth(int patientId);

}
