package com.mediscreennote.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mediscreennote.model.Note;
import com.mediscreennote.model.Response;
import com.mediscreennote.repository.NoteRepository;
import com.mediscreennote.service.INoteService;
import com.mongodb.lang.NonNull;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class NoteController {

static final Logger logger = LogManager.getLogger(NoteController.class);
	
	@Autowired
	private NoteRepository noteRepository;
	
	@Autowired
	private INoteService noteService;
	
	@GetMapping("/")
	public String index() {
		return "Welcome on REST API which communicate with mongo database.";
	}
	
	@GetMapping(value = "/notes")
	public List<Note> getAllPatientNote(int patientId) {
		logger.info("retrieve all patient notes");
		return noteRepository.findByPatientId(patientId);
	}
	
	@PostMapping(value="note")
	@ResponseBody
	public ResponseEntity<Response> addNoteToPatient(@NonNull @RequestBody final Note patientNote) {
		logger.info("create note()");
		return noteService.addNoteToPatient(patientNote);
	}
	
	@PutMapping( value = "/noteUpdated")
	public ResponseEntity<Response> updateNote(@RequestBody Note patientNote) {
		logger.info("update a note");
		return noteService.updatePatientNote(patientNote);
			
	}
	@GetMapping(value = "/noteById")
	public Note getNoteById(@RequestParam String idNote) {
		logger.info("retrieve note by idNote");
		return noteRepository.findById(idNote).orElse(null);
	}
}
