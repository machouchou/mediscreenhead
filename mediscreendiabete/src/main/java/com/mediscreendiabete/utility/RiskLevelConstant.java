package com.mediscreendiabete.utility;

public enum RiskLevelConstant {
	
	NONE("NONE : aucun risque"),
    BORDERLINE("BORDERLINE : risque limité"),
    DANGER("danger"),
    EARLYONSET("EARLYONSET : apparition précoce");

	private String riskLevel;
	
	RiskLevelConstant(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

		
}
