package Backend;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import javax.swing.Timer;

import Unused_Code.SafetyMeasures;

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
	
	public void getContactedPersonSafetyStatus(SafetyMeasures safetyMeasures) {
		this.contactedPersonSafetyStatus = safetyMeasures;
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
	
	public static int initialInfectedStatus() {	//Used for initial infection setup
		//return (int)(Math.random() * 2);
		SecureRandom c = new SecureRandom();
		return c.nextInt(99);
	}
	
	public void generateNewDest() { 
		this.xDest = this.genRanCoord(); 
		this.yDest = this.genRanCoord(); 
	}
	
	public void move() {		
		if(randStatus() == 1) { 
			if((this.xDest - this.xPos < 0) && this.xPos > 0) { 
				this.xPos--; 
				for(int i = 0; i < newJLayer.people.size(); i++) {
					checkIntersect(newJLayer.people.get(i));
				}
			}
			
			else if((this.xDest - this.xPos > 0) && this.xPos < 16) { 
				this.xPos++; 
				for(int i = 0; i < newJLayer.people.size(); i++) {
					checkIntersect(newJLayer.people.get(i));
				}
			}
		} else {
			if((this.yDest - this.yPos < 0) && this.yPos > 0) { 
				this.yPos--;
				for(int i = 0; i < newJLayer.people.size(); i++) {
					checkIntersect(newJLayer.people.get(i));
				}
			}
			 
			else if((this.yDest - this.yPos > 0) && this.yPos < 16) { 
				this.yPos++;
				for(int i = 0; i < newJLayer.people.size(); i++) {
					checkIntersect(newJLayer.people.get(i));
				}
			}
		}
		
		if(this.xPos == this.xDest && this.yPos == this.yDest) {
			generateNewDest();
		}
	}
	
	private void checkIntersect(newPeople other) {
		boolean shapeIntersects = false;
		if(this.getxPos() == other.getxPos() && this.getyPos() == other.getyPos()) {
			shapeIntersects = true;
			System.out.println("intersected");
			this.getContactedPersonInfectStatus(other.getInfectstatus());
			this.getContactedPersonSafetyStatus(other.getSafetyStatus());
		}
		SecureRandom c = new SecureRandom();
		int percentChanceOfInfection = c.nextInt(99);

		if (shapeIntersects) {
			switch (this.contactedPersonInfectStatus) {
			case INFECTED:
				switch (this.contactedPersonSafetyStatus) {
				case NO_MASK:
					if(this.safetyStatus == SafetyMeasures.NO_MASK) {
						if(percentChanceOfInfection < 99) {
							this.setInfectstatus(InfectionType.INFECTED);
						}
					} else {
						if(percentChanceOfInfection < 79) {
							this.setInfectstatus(InfectionType.INFECTED);
						}
					}
					break;
				case WEARING_MASK:
					if(this.safetyStatus == SafetyMeasures.NO_MASK) {
						if(percentChanceOfInfection < 40) {
							this.setInfectstatus(InfectionType.INFECTED);
						}
					} else {
						if(percentChanceOfInfection < 20) {
							this.setInfectstatus(InfectionType.INFECTED);
						}
					}
					break;
				}
				break;
			case NOT_INFECTED:
				/*switch (this.contactedPersonSafetyStatus) {
				case NO_MASK:
					if(this.safetyStatus == SafetyMeasures.NO_MASK) {
						//Nothing
					} else {
						
					}
					break;
				case WEARING_MASK:
					if(this.safetyStatus == SafetyMeasures.NO_MASK) {
						
					} else {
						
					}
					break;
				}*/
				break;
			}
		}
	}
}
