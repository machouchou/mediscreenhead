package com.mediscreendiabete.utility;

public enum DiabeteTrigger {
	
	/** Hemoglobine A1C. */
    HEMOGLOBINE_A1C("Hémoglobine A1C".toUpperCase()),
    
    /** Microalbumine. */
    MICROALBUMINE("Microalbumine".toUpperCase()),
    
    /** Taille. */
    TAILLE("Taille".toUpperCase()),
    
    /** Poids. */
    POIDS("Poids".toUpperCase()),
    
    /** Fumeur. */
    FUMEUR("Fumeur".toUpperCase()),
    
    /** Anormal. */
    ANORMAL("Anormal".toUpperCase()),
    
    /** Cholesterol. */
    CHOLESTEROL("Cholestérol".toUpperCase()),
    
    /** Vertige. */
    VERTIGE("Vertige".toUpperCase()),
    
    /** Rechute. */
    RECHUTE("Rechute".toUpperCase()),
    
    /** Reaction. */
    REACTION("Réaction".toUpperCase()),
    
    /** Anticorps. */
    ANTICORPS("Anticorps".toUpperCase());
	
	private String trigger;

	DiabeteTrigger(String trigger) {
		this.trigger = trigger;	}

	public String getTrigger() {
		return trigger;
	}

	public void setTrigger(String trigger) {
		this.trigger = trigger;
	}


}
