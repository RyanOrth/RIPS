package Frontend;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import Backend.PersonBehavior.InfectionType;
import Backend.PersonBehavior.SafetyMeasures;

public class PersonGraphics {
	private Shape personShape;
	private Color personColor;
	
	public Object generatePersonShape(double xPos, double yPos, SafetyMeasures safetyMeasures) {
		if(safetyMeasures == SafetyMeasures.WEARING_MASK) {
			return new Ellipse2D.Double(xPos, yPos, 6, 6);
		}else {
			return new Polygon(new int[] {((int) xPos-3), (int) xPos, ((int) xPos + 3)}, 
				new int[] {((int)yPos + 3), (int)yPos, ((int)yPos-3)}, 3);
		}
	}	
	public Color generatePersonColor(InfectionType infectionType) {
		if(infectionType == InfectionType.INFECTED) {
			return Color.RED;
		}else {
			return Color.BLUE;
		}
	}
	
	public Ellipse2D.Double generateInfectionCircle(double xPos, double yPos, InfectionType infectionType,SafetyMeasures safetyMeasures){
		if(infectionType == InfectionType.INFECTED) {
			if(safetyMeasures == SafetyMeasures.WEARING_MASK) {
				return new Ellipse2D.Double(xPos, yPos, 9, 9);
			}else {
				return new Ellipse2D.Double(xPos, yPos, 12, 12);
			}
		}else {
			return new Ellipse2D.Double(xPos, yPos, 0, 0);
		}
	}
	
	public Color colorInfectionCircle(SafetyMeasures safetyMeasures, Ellipse2D.Double infectionCircle){
		if(safetyMeasures == SafetyMeasures.WEARING_MASK) {
			return new Color((float) 203,(float) 206,(float) 212,(float) 0.5);
		}else {
			return new Color((float) 128,(float) 255,(float) 0,(float) 0.5);
		}
	}
}