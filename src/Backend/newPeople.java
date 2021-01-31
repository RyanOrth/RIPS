package Backend;

import java.util.List;

import javax.swing.Timer;

public class newPeople {
	public static InfectionType infectionStatus[] = {InfectionType.INFECTED, InfectionType.NOT_INFECTED};
	public static SafetyMeasures safetyMeasureStatus[] = {SafetyMeasures.NO_MASK, SafetyMeasures.WEARING_MASK};
	
	int xPos;
	int yPos;
	Timer timer; 
	int xDest; 
	int yDest; 
	InfectionType infectstatus;
	SafetyMeasures safetyStatus; 
	public newPeople(int xPos, int yPos, Timer timer, int xDest, int yDest, InfectionType infectStatus, SafetyMeasures safetyStatus) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.timer = timer;
		this.xDest = xDest;
		this.yDest = yDest;
		this.infectstatus = infectStatus; 
		this.safetyStatus = safe
	} 

	public static int genRanCoord() {	//Generate random coordinate point
		return (int)(Math.random() * 16);
	}
	
	
	
	

}
