package Backend;

public class PersonBehavior {
	public enum InfectionType {
		INFECTED, NOT_INFECTED,
	}
	
	public enum SafetyMeasures {
		NO_MASK, WEARING_MASK,
	}
	
	InfectionType infectionStatus;
	SafetyMeasures safetyMeasureStatus;
	
	public PersonBehavior(InfectionType infectionStatus, SafetyMeasures safetyMeasureStatus) {
		setInfectionType(infectionStatus);
		setSafetyMeasures(safetyMeasureStatus);
	}
	
	private void setInfectionType(InfectionType infectionStatus) {
		this.infectionStatus = infectionStatus;
	}
	
	private void setSafetyMeasures(SafetyMeasures safetyMeasureStatus) {
		this.safetyMeasureStatus = safetyMeasureStatus;
	}
}
