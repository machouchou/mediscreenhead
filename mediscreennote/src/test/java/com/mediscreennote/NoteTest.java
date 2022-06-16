package com.mediscreennote;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

import com.mediscreennote.model.Note;
import com.mediscreennote.model.Response;
import com.mediscreennote.repository.NoteRepository;
import com.mediscreennote.service.NoteService;

@SpringBootTest
@TestPropertySource("/applicationtest.properties")
@DirtiesContext
public class NoteTest {
	
	final Logger logger = LogManager.getLogger(NoteTest.class);

	@Autowired
	private NoteRepository noteRepository;
	
	@Autowired
	private NoteService noteService;
	
	@Autowired
	private MongoTemplate mongoTemplate;
    private String collectionName = "mediscreentest";

    @BeforeEach
    public void setup() {
    	mongoTemplate.dropCollection("notes");
        mongoTemplate.createCollection("notes");
    }

    @Test
    public void getAllNoteForPatient() {

        Note note1 = new Note();
        note1.setId("1");
        note1.setNote("note");
        note1.setPatientId(1);
        noteService.addNoteToPatient(note1);
        
        Note note2 = new Note();
        note2.setId("2");
        note2.setNote("note");
        note2.setPatientId(1);
        noteService.addNoteToPatient(note2);
        List<Note> noteResult = noteService.getAllNote(1);
        
        assertNotEquals(Collections.EMPTY_LIST, noteResult.size());
        assertEquals(noteResult.size(), 2);
    }

    @Test
    public void addNoteForPatient() {
    	logger.debug("Calling add note");
		
        Note note = new Note();
        note.setId("mongo1");
        note.setPatientId(5);
        note.setNote("note");
        ResponseEntity<Response> response = noteService.addNoteToPatient(note);
        Note noteResult = (Note)response.getBody().getData();
        
        assertEquals(noteResult, note);
        assertEquals(5, note.getPatientId());
    }

    @Test
    public void updateNoteForPatient() {
    	logger.debug("Calling update note");
    	getAllNoteForPatient();
    	Note existingNote  = noteRepository.findById("1").orElse(null);
    	
        existingNote.setId("1");
        existingNote.setPatientId(1);
        existingNote.setNote("noteA");
        ResponseEntity<Response> response = noteService.updatePatientNote(existingNote);
        Note noteResult = (Note)response.getBody().getData();
        
        assertEquals(1, noteResult.getPatientId());
        assertEquals("noteA", noteResult.getNote());
    }
}
