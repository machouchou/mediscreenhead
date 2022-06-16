package com.mediscreendiabete.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mediscreendiabete.model.DiabeteAssess;
import com.mediscreendiabete.model.Note;
import com.mediscreendiabete.model.Patient;
import com.mediscreendiabete.model.Response;
import com.mediscreendiabete.service.AssessmentService;

/**
* The Class DiabeteController.
*/
@CrossOrigin(origins = "*")
//@RequestMapping("/")
@RestController
public class DiabeteController {
	
	static final Logger logger = LogManager.getLogger(DiabeteController.class);
	
	@Autowired
	private AssessmentService assessmentService;
	
	@GetMapping(value = "/patientById")
	public ResponseEntity<Response<Patient>> getPatientById(@RequestParam Integer patientId) {
		return assessmentService.getPatient(patientId);
	}
	
	@GetMapping(value = "/notes")
	public List<Note> getAllPatientNote(@RequestParam int patientId) {
		return assessmentService.getPatientNotes(patientId);
	}

	@GetMapping(value = "/assess")
	public DiabeteAssess assessPatientHealth(@RequestParam int patientId) {
		logger.info("retrieve patient level risk");
		return assessmentService.getdiabeteAssess(patientId);
	}
	
}
