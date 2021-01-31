package Unused_Code;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;
import javax.swing.Timer;

import Backend.InfectionType;

import java.util.Scanner;


public class PersonBehavior implements ActionListener{
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
	Timer timer; 
	int xDest; // xPos destination
	int yDest; // yPos destination
	

	
	public PersonBehavior(int xPos, int yPos, InfectionType infectionStatus, SafetyMeasures safetyMeasureStatus, Graphics2D paint) {
		setInfectionType(infectionStatus);
		setSafetyMeasures(safetyMeasureStatus);
		setPos(xPos, yPos, paint);
		genDestination();
		
		timer = new Timer(10, this);
		timer.start();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Random ran = new Random(); 
		
		if(ran.nextDouble() <= 0.5) { 
			if(xDest - xPos < 0) { 
				xPos++; 
			}
			
			if(xDest - xPos > 0) { 
				xPos--; 
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



}
