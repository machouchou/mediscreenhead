package com.mediscreendiabete.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mediscreendiabete.model.DiabeteAssess;
import com.mediscreendiabete.model.Note;
import com.mediscreendiabete.model.Patient;
import com.mediscreendiabete.model.Response;
import com.mediscreendiabete.proxies.MediscreenNoteProxy;
import com.mediscreendiabete.proxies.MediscreenProxy;
import com.mediscreendiabete.utility.DiabeteTrigger;
import com.mediscreendiabete.utility.RiskLevelConstant;

@Service
public class AssessmentService implements IAssessment {
	
	private Logger logger = LoggerFactory.getLogger(AssessmentService.class);
	
	private final MediscreenProxy patientProxy;
	private final MediscreenNoteProxy noteProxy;
	
	

	public AssessmentService(MediscreenProxy patientProxy, MediscreenNoteProxy noteProxy) {
		this.patientProxy = patientProxy;
		this.noteProxy = noteProxy;
	}

	@Override
	public DiabeteAssess getdiabeteAssess(int patientId) {
		logger.debug("retrieve patient risk level");
		ResponseEntity<Response<Patient>> patient = getPatient(patientId);
		
		Patient pt = patient.getBody().getData();
		
        List<Note> patientNotes = getPatientNotes(patientId);
        
        int patientAge = getAge(pt.getBirthDate());
        
        int patientTriggers = getPatientTriggers(patientNotes);
        
        String diabeteRiskLevel = measureRiskLevel(patientAge, patientTriggers, pt.getSex());
      
        return new DiabeteAssess(pt, patientAge, diabeteRiskLevel);
	}

	/**
	   * Gets the patient triggers.
	   *
	   * @param notes the notes
	   * @return the patient triggers
	   */
	  // How many Triggers (count number of triggers in all notes of patient)
	  public int getPatientTriggers(final List<Note> notes) {
	
	      EnumSet<DiabeteTrigger> diabetesTriggers = EnumSet
	      		.allOf(DiabeteTrigger.class);
	      StringBuilder patientNotes = new StringBuilder(512);
	        for (Note note : notes) {
	        	patientNotes.append(note.getNote().toUpperCase());
				patientNotes.append(" ");
			}
	        String noteRecap = patientNotes.toString();
	        
	      List<DiabeteTrigger> patientTriggers = new ArrayList();
	      diabetesTriggers.forEach(diabetesTrigger -> {
	    	  if (noteRecap.contains(diabetesTrigger.getTrigger()) &&
	                      !patientTriggers.contains(diabetesTrigger)) {
	    		  patientTriggers.add(diabetesTrigger);
	    	  }
	    	  
	      });
	      return patientTriggers.size();
	  }
	  
	  /**Get patient by Id through mediscreenproxy
	   * 
	   * @param patientId
	   * @return
	   */
		public ResponseEntity<Response<Patient>> getPatient(final Integer patientId) {
				
				ResponseEntity<Response<Patient>> patient = patientProxy.getPatientById(patientId);
							
				return patient;
			}
	
	
	/** Get the patients notes through proxy
	 * 
	 * @param patientId
	 * @return all notes of the patient 
	 */
    public List<Note> getPatientNotes(final int patientId) {

		List<Note> patientNotes = noteProxy.getAllPatientNote(patientId);

		return patientNotes;
	}
	@Override
	public Optional<Patient> getPatient(String firstName, String lastName) {
		
		Optional<Patient> patient = patientProxy.getPatientByFirstAndLastName(firstName, lastName);
		return patient;
	}

	/**
	   * Gets the age.
	   *
	   * @param birthDate the birth date
	   * @return the age
	   */
	  
	  public int getAge(final LocalDate birthDate) {
	
	      LocalDate currentDate = LocalDate.now();
	      int age = Period.between(birthDate, currentDate).getYears();
	
	      if (birthDate.isAfter(currentDate)) {
	          throw new IllegalArgumentException("birth date is invalid"
	          		+ " - should be before current date");
	      } else if (age == 0) {
	          age++;
      }

      return age;
  }

	public String measureRiskLevel(int age, int trigger, String sex) {
		logger.debug("risk level calculate");
		String diabeteRiskLevel = RiskLevelConstant.NONE.getRiskLevel();
		
		if ((sex.equals("M") && age < 30 && trigger >= 5)
				||(sex.equals("F") && age < 30 && trigger >= 7)
				|| (age > 30 && trigger >= 8)) {
			
			return diabeteRiskLevel = RiskLevelConstant.EARLYONSET.getRiskLevel();
			
		} else
			if ((sex.equals("M") && age < 30 && trigger >= 3)
				||(sex.equals("F") && age < 30 && trigger >= 4)
				|| (age > 30 && trigger >= 6)) {
				
				return diabeteRiskLevel = RiskLevelConstant.DANGER.getRiskLevel();
				
			} else
				if ( age >= 30 && trigger >= 2) {
					
					return diabeteRiskLevel = RiskLevelConstant.BORDERLINE.getRiskLevel();
					
				}  
				return diabeteRiskLevel;
				
	}
}
