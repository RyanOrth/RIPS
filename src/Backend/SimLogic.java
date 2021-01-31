package Backend;

import Backend.PersonBehavior.*;
import Frontend.WindowGenerator;

import java.util.List;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class SimLogic extends JFrame {

	static List<PersonBehavior> person = new ArrayList<PersonBehavior>();
	static InfectionType infectionStatus[] = {InfectionType.INFECTED, InfectionType.NOT_INFECTED};
	static SafetyMeasures safetyMeasureStatus[] = {SafetyMeasures.NO_MASK, SafetyMeasures.WEARING_MASK};

	public static Graphics2D g2;
	
	/*public void paint(Graphics g) {
		super.paint(g);
	    g2 = (Graphics2D) g;
	    for(int i = 0; i < 25; i++) {
			int posX = genRanCoord();
			int posY = genRanCoord();
			
			InfectionType infectionStatusValue = infectionStatus[randStatus()];
			SafetyMeasures safetyMeasuresValue = safetyMeasureStatus[randStatus()];
			
			person.add(new PersonBehavior(posX, posY, infectionStatusValue, safetyMeasuresValue, g2));
			
			System.out.println("Location (" + posX + ", " + posY + "), Infection Type: " + infectionStatusValue + ", Safety Measures: " + safetyMeasuresValue);
		}
	}*/
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
	    
	    for(int i = 0; i < 25; i++) {
			int posX = genRanCoord();
			int posY = genRanCoord();
			
			InfectionType infectionStatusValue = infectionStatus[randStatus()];
			SafetyMeasures safetyMeasuresValue = safetyMeasureStatus[randStatus()];
			
			System.out.println("In SimLogic paint method just before person.add");
			person.add(new PersonBehavior(posX, posY, infectionStatusValue, safetyMeasuresValue, g2));
			
			System.out.println("Location (" + posX + ", " + posY + "), Infection Type: " + infectionStatusValue + ", Safety Measures: " + safetyMeasuresValue);
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		WindowGenerator.main(args);
		
		System.out.println("Back in SimLogin");
		/*for(int i = 0; i < 25; i++) {
			int posX = genRanCoord();
			int posY = genRanCoord();
			
			InfectionType infectionStatusValue = infectionStatus[randStatus()];
			SafetyMeasures safetyMeasuresValue = safetyMeasureStatus[randStatus()];
			
			person.add(new PersonBehavior(posX, posY, infectionStatusValue, safetyMeasuresValue, g2));
			
			System.out.println("Location (" + posX + ", " + posY + "), Infection Type: " + infectionStatusValue + ", Safety Measures: " + safetyMeasuresValue);
		}*/
	}
	
	public static int genRanCoord() {	//Generate random coordinate point
		return (int)(Math.random() * 16);
	}
	
	private static int randStatus() {	//Used for infectionStatus and safetyMeasureStatus
		return (int)(Math.random() * 2);
	}
}
