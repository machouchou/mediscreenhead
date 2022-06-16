package com.mediscreennote.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mediscreennote.model.Note;
import com.mediscreennote.model.Response;
import com.mediscreennote.repository.NoteRepository;
import com.mediscreennote.utility.Constant;
import com.mediscreennote.utility.Utility;

@Service
public class NoteService implements INoteService {

	final Logger logger = LogManager.getLogger(NoteService.class);
	
	@Autowired
	NoteRepository noteRepository;
	
	private Utility utility;
	
	private Response response;
	
	public NoteService() {
		utility = new Utility();
		response = new Response();
	}

	@Override
	public List<Note> getAllNote(int patientId) {
		return noteRepository.findByPatientId(patientId);
	}
	
	
	@Override
	public ResponseEntity<Response> addNoteToPatient(Note note) {
		
		String errorDescription = "";
		if (note == null) {
			errorDescription = "Enter a valid Note !"; 
			return utility.createResponseWithErrors(Constant.ERROR_MESSAGE_NOTE_REQUIRED, errorDescription);
		}
		noteRepository.insert(note);
		
		new Utility().createResponseWithSuccess(response, note);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Response> updatePatientNote(Note note) {
		
		String errorDescription = "";
		if (note == null) {
			errorDescription = "Enter a valid Patient !"; 
			return utility.createResponseWithErrors(Constant.ERROR_MESSAGE_NOTE_REQUIRED, errorDescription);
		}
		Note existingNote = noteRepository.findById(note.getId()).orElse(null);
		if (existingNote == null) {
			errorDescription = "Note not found !"; 
			return utility.createResponseWithErrors(Constant.ERROR_MESSAGE_NOTE_REQUIRED, errorDescription);
		
		}
 		existingNote.setNote(note.getNote());
 		existingNote.setPatientId(note.getPatientId());
		noteRepository.save(note);
		
		new Utility().createResponseWithSuccess(response, note);
		
		return new ResponseEntity<>(response, HttpStatus.OK); 
	}
}
