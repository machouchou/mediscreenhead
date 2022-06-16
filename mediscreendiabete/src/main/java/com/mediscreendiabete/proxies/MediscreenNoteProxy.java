package com.mediscreendiabete.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mediscreendiabete.model.Note;

@FeignClient(name = "mediscreennote", url = "mediscreennote:8082")
public interface MediscreenNoteProxy {

	/**
	 * Get all notes of the patient retrieves by id
	 * @param patientId
	 * @return all notes.
	 */
	@GetMapping(value = "/notes")
	public List<Note> getAllPatientNote(@RequestParam int patientId);
}
