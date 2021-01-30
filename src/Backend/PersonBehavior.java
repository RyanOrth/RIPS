package Backend;

import java.util.TimerTask;

public class PersonBehavior extends TimerTask{
	public enum InfectionType {
		INFECTED, NOT_INFECTED,
	}
	
	public enum SafetyMeasures {
		NO_MASK, WEARING_MASK,
	}
	
	InfectionType infectionStatus;
	SafetyMeasures safetyMeasureStatus;
	int xPos;
	int yPos;
	
	public PersonBehavior(int xPos, int yPos, InfectionType infectionStatus, SafetyMeasures safetyMeasureStatus) {
		setPos(xPos, yPos);
		setInfectionType(infectionStatus);
		setSafetyMeasures(safetyMeasureStatus);
	}
	
	public void setInfectionType(InfectionType infectionStatus) {
		this.infectionStatus = infectionStatus;
	}
	
	public void setSafetyMeasures(SafetyMeasures safetyMeasureStatus) {
		this.safetyMeasureStatus = safetyMeasureStatus;
	}
	
	public void setPos(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		//Update the shape position here
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	
	
	
	

}
