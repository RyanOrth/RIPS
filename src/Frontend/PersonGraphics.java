package Frontend;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;

import Backend.InfectionType;
import Backend.SafetyMeasures;

public class PersonGraphics {
	
	public static void generatePersonGraphics(double xPos, double yPos, SafetyMeasures safetyMeasures, InfectionType infectionType, Graphics2D paint) {
		System.out.println("In generate person graphics");
		if(infectionType == InfectionType.INFECTED) {
			paint.setBackground(Color.RED);
			System.out.println("Background set to red");
		}else {
			paint.setBackground(Color.BLUE);
			System.out.println("Background set to blue");
		}
		if(safetyMeasures == SafetyMeasures.WEARING_MASK) {
			paint.draw(new Ellipse2D.Double(xPos, yPos, 6, 6));
		}else {
			paint.draw(new Polygon(new int[] {((int) xPos-3), (int) xPos, ((int) xPos + 3)}, 
				new int[] {((int)yPos + 3), (int)yPos, ((int)yPos-3)}, 3));
		}
		if(safetyMeasures == SafetyMeasures.WEARING_MASK) {
			paint.setBackground(new Color(203, 206, 212, 127));
		}else {
			paint.setBackground(new Color(128, 255, 0, 127));
		}
		if(infectionType == InfectionType.INFECTED) {
			if(safetyMeasures == SafetyMeasures.WEARING_MASK) {
				paint.draw(new Ellipse2D.Double(xPos, yPos, 9, 9));
			}else {
				paint.draw(new Ellipse2D.Double(xPos, yPos, 12, 12));
			}
		}else {
			paint.draw(new Ellipse2D.Double(xPos, yPos, 0, 0));
		}
	}	
}