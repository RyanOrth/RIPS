package Backend;

import Backend.PersonBehavior.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class SimLogic {

	static List<PersonBehavior> person = new ArrayList<PersonBehavior>();
	static InfectionType infectionStatus[] = {InfectionType.INFECTED, InfectionType.NOT_INFECTED};
	static SafetyMeasures safetyMeasureStatus[] = {SafetyMeasures.NO_MASK, SafetyMeasures.WEARING_MASK};

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		
		for(int i = 0; i < 25; i++) {
			int posX = genRanCoord();
			int posY = genRanCoord();
			
			InfectionType infectionStatusValue = infectionStatus[randStatus()];
			SafetyMeasures safetyMeasuresValue = safetyMeasureStatus[randStatus()];
			
			person.add(new PersonBehavior(posX, posY, infectionStatusValue, safetyMeasuresValue));
			
			System.out.println("Location (" + posX + ", " + posY + "), Infection Type: " + infectionStatusValue + ", Safety Measures: " + safetyMeasuresValue);
		}
	}
	
	private static int genRanCoord() {	//Generate random coordinate point
		int range = 16;	//Max - min + 1
		int rand = (int)(Math.random() * range);
		return rand;
	}
	
	private static int randStatus() {	//Used for infectionStatus and safetyMeasureStatus
		int range = 2;
		int rand = (int)(Math.random() * range);
		return rand;
	}

}
