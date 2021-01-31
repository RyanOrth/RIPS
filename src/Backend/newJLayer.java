package Backend;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
			InfectionType infectionStatusValue = newPeople.infectionStatus[((int)Math.random())];
			SafetyMeasures safetyStatus = newPeople.safetyMeasureStatus[((int)Math.random())];
			people.add(newPeople(xPos, yPos, timer, int xDest, int yDest, infectionStatusValue, safetyStatus));
		}
	}
	
	public newJLayer() {
		this.setBounds(0, 0, 1200, 850);
		timer = new Timer(10000, this); 
		timer.start();
	}
	
	public void paint(Graphics g) { 
		Graphics2D g1 = (Graphics2D) g;
		for(newPeople person : people) {
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
