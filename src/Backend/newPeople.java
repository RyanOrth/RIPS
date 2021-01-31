package Backend;

import java.util.List;

import javax.swing.Timer;

public class newPeople {
	int xPos;
	int yPos;
	Timer timer; 
	int xDest; 
	int yDest; 
	InfectionType infectionStatus;

	public static InfectionType infectionStatus[] = {InfectionType.INFECTED, InfectionType.NOT_INFECTED};
	public static SafetyMeasures safetyMeasureStatus[] = {SafetyMeasures.NO_MASK, SafetyMeasures.WEARING_MASK};
	
	public newPeople(int xPos, int yPos, Timer timer, int xDest, int yDest, InfectionType infectionStatus, SafetyMeasures safetyStatus) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.timer = timer;
		this.xDest = xDest;
		this.yDest = yDest;
		this.infected = infected;
		this.mask = mask;
	} 

	public static int genRanCoord() {	//Generate random coordinate point
		return (int)(Math.random() * 16);
	}
	
	
	
	public List<newPeople>getPeoples() { 
		for()
		
	}
	
	

}
