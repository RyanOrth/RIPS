package Backend;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

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

	public void getContactedPersonInfectStatus(InfectionType infectstatus) {
		this.contactedPersonInfectStatus = infectstatus;
	}
	
	public void getContactedPersonSafetyStatus(InfectionType safetyStatus) {
		this.contactedPersonInfectStatus = safetyStatus;
	}
	
	public static SafetyMeasures safetyMeasureStatus[] = {SafetyMeasures.NO_MASK, SafetyMeasures.WEARING_MASK};
	
	int xPos;
	int yPos;
	Timer timer; 
	int xDest; 
	int yDest; 
	InfectionType infectstatus;
	SafetyMeasures safetyStatus; 
	
	InfectionType contactedPersonInfectStatus;
	SafetyMeasures contactedPersonSafetyStatus;
	public newPeople(int xPos, int yPos, Timer timer, InfectionType infectStatus, SafetyMeasures safetyStatus) {
		this.xPos = 2/*xPos*/;
		this.yPos = 2/*yPos*/;
		this.timer = timer;
		this.infectstatus = infectStatus; 
		this.safetyStatus = safetyStatus; 
		generateNewDest();
	} 

	public static int genRanCoord() {	//Generate random coordinate point
		//return (int)(Math.random() * 16);
		SecureRandom c = new SecureRandom();
		return c.nextInt(15);
	}
	public static int randStatus() {	//Used for infectionStatus and safetyMeasureStatus
		//return (int)(Math.random() * 2);
		SecureRandom c = new SecureRandom();
		return c.nextInt(2);
	}
	
	public void generateNewDest() { 
		this.xDest = this.genRanCoord(); 
		this.yDest = this.genRanCoord(); 
	}
	
	public void move() {		
		if(randStatus() == 1) { 
			if((this.xDest - this.xPos < 0) && this.xPos > 0) { 
				this.xPos--; 
			}
			
			else if((this.xDest - this.xPos > 0) && this.xPos < 16) { 
				this.xPos++; 
			}
		} else {
			if((this.yDest - this.yPos < 0) && this.yPos > 0) { 
				this.yPos--;
			}
			 
			else if((this.yDest - this.yPos > 0) && this.yPos < 16) { 
				this.yPos++;
			}
		}
		
		if(this.xPos == this.xDest && this.yPos == this.yDest) {
			generateNewDest();
		}
	}
	
	private void checkIntersect() {
		boolean shapeIntersects = true;
		SecureRandom c = new SecureRandom();
		int percentChanceOfInfection = c.nextInt(99);
		if (shapeIntersects) {
			switch (this.infectstatus) {
			case INFECTED:
				switch (this.safetyStatus) {
				case NO_MASK:
					
					break;
				case WEARING_MASK:
					break;
				}
				break;
			case NOT_INFECTED:
				switch (this.safetyStatus) {
				case NO_MASK:
					break;
				case WEARING_MASK:
					break;
				}
				break;
			}
		}
	}
}
