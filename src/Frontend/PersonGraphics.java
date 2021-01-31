package Frontend;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;

import Backend.InfectionType;
import Backend.SafetyMeasures;

public class PersonGraphics {
	
	public static void generatePersonGraphics(double xPos, double yPos, SafetyMeasures safetyMeasures, InfectionType infectionType, Graphics2D paint) {
		if(infectionType == InfectionType.INFECTED) {
			paint.setBackground(Color.RED);
		}else {
			paint.setBackground(Color.BLUE);
		}
		if(safetyMeasures == SafetyMeasures.WEARING_MASK) {
			paint.draw(new Ellipse2D.Double(xPos, yPos, 6, 6));
		}else {
			paint.draw(new Polygon(new int[] {((int) xPos-3), (int) xPos, ((int) xPos + 3)}, 
				new int[] {((int)yPos + 3), (int)yPos, ((int)yPos-3)}, 3));
		}
		if(safetyMeasures == SafetyMeasures.WEARING_MASK) {
			paint.setBackground(new Color((float) 203,(float) 206,(float) 212,(float) 0.5));
		}else {
			paint.setBackground(new Color((float) 128,(float) 255,(float) 0,(float) 0.5));
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