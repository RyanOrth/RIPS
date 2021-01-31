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
	
	public Object generatePersonShape(SafetyMeasures safetyMeasures, double xPos, double yPos) {
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
	
	public Ellipse2D.Double generateInfectionCircle(InfectionType infectionType, double xPos, double yPos){
		if(infectionType == InfectionType.INFECTED) {
			return new Ellipse2D.Double(xPos, yPos, 12, 12);
		}else {
			return new Ellipse2D.Double(xPos, yPos, 0, 0);
		}
	}
}