package Backend;

import java.util.List;

import javax.swing.Timer;

public class newPeople {
	public static InfectionType infectionStatus[] = {InfectionType.INFECTED, InfectionType.NOT_INFECTED};
	public static InfectionType[] getInfectionStatus() {
		return infectionStatus;
	}

	public static void setInfectionStatus(InfectionType[] infectionStatus) {
		newPeople.infectionStatus = infectionStatus;
	}

	public static SafetyMeasures[] getSafetyMeasureStatus() {
		return safetyMeasureStatus;
	}

	public static void setSafetyMeasureStatus(SafetyMeasures[] safetyMeasureStatus) {
		newPeople.safetyMeasureStatus = safetyMeasureStatus;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public int getxDest() {
		return xDest;
	}

	public void setxDest(int xDest) {
		this.xDest = xDest;
	}

	public int getyDest() {
		return yDest;
	}

	public void setyDest(int yDest) {
		this.yDest = yDest;
	}

	public InfectionType getInfectstatus() {
		return infectstatus;
	}

	public void setInfectstatus(InfectionType infectstatus) {
		this.infectstatus = infectstatus;
	}

	public SafetyMeasures getSafetyStatus() {
		return safetyStatus;
	}

	public void setSafetyStatus(SafetyMeasures safetyStatus) {
		this.safetyStatus = safetyStatus;
	}

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
		this.safetyStatus = safetyStatus; 
	} 

	public static int genRanCoord() {	//Generate random coordinate point
		return (int)(Math.random() * 16);
	}
	public static int randStatus() {	//Used for infectionStatus and safetyMeasureStatus
		return (int)(Math.random() * 2);
	}
	
	public void generateNewDest() { 
		this.xDest = this.genRanCoord(); 
		this.yDest = this.genRanCoord(); 
	}
	
	
	

}
