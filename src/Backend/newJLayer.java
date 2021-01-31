package Backend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.Timer;


public class newJLayer extends JLayeredPane implements ActionListener{
	Timer timer; 
	
	ArrayList<newPeople> people = new ArrayList<newPeople>();
	
	public void initializePeople() {
		for(int i = 0; i < 5; i++) {
			int xPos = newPeople.genRanCoord();
			int yPos = newPeople.genRanCoord();
			int xDest = newPeople.genRanCoord();
			int yDest = newPeople.genRanCoord();
			InfectionType infectionStatusValue = newPeople.infectionStatus[newPeople.randStatus()];
			SafetyMeasures safetyStatus = newPeople.safetyMeasureStatus[newPeople.randStatus()];
			people.add(new newPeople(xPos, yPos, timer, xDest, yDest, infectionStatusValue, safetyStatus));
		}
	}
	
	public newJLayer() {
		NewPanel panel = new NewPanel();
		this.setBounds(0, 0, 1200, 850);
		this.add(panel);
		timer = new Timer(10000, this); 
		timer.start();
		initializePeople();
	}
	
	public void paint(Graphics g) { 
		Graphics2D g2 = (Graphics2D) g;
		for(newPeople person : people) {
			InfectionType infectionStatusValue = person.getInfectstatus();
			SafetyMeasures safetyStatus = person.getSafetyStatus();
			int xPos = person.getxPos();
			int yPos = person.getyPos();
			int xDest = person.getxDest();
			int yDest = person.getyDest();
			
			xPos *= 50;
			xPos += 50;
			yPos *= 50;
			yPos += 50;

			if (infectionStatusValue == InfectionType.INFECTED) {
				g2.setColor(Color.RED);
			} else {
				g2.setColor(Color.BLUE);
			}
			if (safetyStatus == SafetyMeasures.WEARING_MASK) {
				g2.fill(new Ellipse2D.Double(xPos - 6, yPos - 6, 12, 12));
			} else {
				g2.fill(new Polygon(new int[] { ((int) xPos - 10), (int) xPos, ((int) xPos + 10) },
						new int[] { ((int) yPos + 7), ((int) yPos - 12), ((int) yPos + 7) }, 3));
			}
			if (safetyStatus == SafetyMeasures.WEARING_MASK) {
				g2.setColor(new Color(203, 206, 212, 127));
			} else {
				g2.setColor(new Color(128, 255, 0, 127));
			}
			if (infectionStatusValue == InfectionType.INFECTED) {
				if (safetyStatus == SafetyMeasures.WEARING_MASK) {
					g2.fill(new Ellipse2D.Double(xPos - 9, yPos - 9, 18, 18));
				} else {
					g2.fill(new Ellipse2D.Double(xPos - 12, yPos - 12, 24, 24));
				}
			} else {
				g2.fill(new Ellipse2D.Double(xPos, yPos, 0, 0));
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
