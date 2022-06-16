package com.mediscreendiabete.model;

public class DiabeteAssess {
	
	private Patient patient;
	
	private int age;
	
	private String diabeteRiskLevel;

	public DiabeteAssess() {
	}

	public DiabeteAssess(Patient patient, int age, String diabeteRiskLevel) {
		super();
		this.patient = patient;
		this.age = age;
		this.diabeteRiskLevel = diabeteRiskLevel;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDiabeteRiskLevel() {
		return diabeteRiskLevel;
	}

	public void setDiabeteRiskLevel(String diabeteRiskLevel) {
		this.diabeteRiskLevel = diabeteRiskLevel;
	}
	
	
	

}
