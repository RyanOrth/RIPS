package Backend;

import java.awt.Graphics2D;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Frontend.PersonGraphics;
import Frontend.WindowGenerator;

import java.util.Scanner;


public class PersonBehavior implements Runnable{
	/*public enum InfectionType {
		INFECTED, NOT_INFECTED,
	}

	public enum SafetyMeasures {
		NO_MASK, WEARING_MASK,
	}*/
	
	InfectionType infectionStatus;
	SafetyMeasures safetyMeasureStatus;
	int xPos;
	int yPos;

	int xDest; // xPos destination
	int yDest; // yPos destination
	
	static ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
	@Override
	public void run() {
		Random ran = new Random(); 
		
		if(ran.nextDouble() <= 0.5) { 
			if(xDest - xPos < 0) { 
				xDest++; 
			}
			
			if(xDest - xPos > 0) { 
				xDest--; 
			}
		} else {
			if(yDest - yPos > 0) { 
				yPos++; 
			}
			 
			if(yDest - yPos < 0) { 
				yPos--; 
			}
		}
	}
	
	public PersonBehavior(int xPos, int yPos, InfectionType infectionStatus, SafetyMeasures safetyMeasureStatus, Graphics2D paint) {
		setInfectionType(infectionStatus);
		setSafetyMeasures(safetyMeasureStatus);
		setPos(xPos, yPos, paint);
		genDestination();
		
		int randomTime = (int) ((Math.random() * 3) + 1); 
		executor.scheduleAtFixedRate(this, 2, randomTime, TimeUnit.SECONDS); 
	}

	public void setInfectionType(InfectionType infectionStatus) {
		this.infectionStatus = infectionStatus;
	}

	public void setSafetyMeasures(SafetyMeasures safetyMeasureStatus) {
		this.safetyMeasureStatus = safetyMeasureStatus;
	}

	public void setPos(int xPos, int yPos, Graphics2D paint) {
		this.xPos = xPos;
		this.yPos = yPos;
		// Update the shape position here
		
		WindowGenerator.generatePersonGraphics((double) xPos,(double) yPos, this.safetyMeasureStatus, this.infectionStatus);
	}

	public void genDestination() {
		this.xDest = SimLogic.genRanCoord();
		this.yDest = SimLogic.genRanCoord();
	}

	private void checkIntersect() {
		boolean shapeIntersects = true;
		if (shapeIntersects) {
			switch (this.infectionStatus) {
			case INFECTED:
				switch (this.safetyMeasureStatus) {
				case NO_MASK:
					break;
				case WEARING_MASK:
					break;
				}
				break;
			case NOT_INFECTED:
				switch (this.safetyMeasureStatus) {
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
