package com.mediscreennote.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mediscreennote.model.Note;
import com.mediscreennote.model.Response;

public interface INoteService {
	
	List<Note> getAllNote(int patientId);
	
	ResponseEntity<Response> addNoteToPatient(Note note);

	ResponseEntity<Response> updatePatientNote(Note note);

}
