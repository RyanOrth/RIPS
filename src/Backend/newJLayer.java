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
			people.add(newPeople(xPos, int yPos, Timer timer, int xDest, int yDest, InfectionType infectionStatus, SafetyMeasures safetyStatus));
		}
	}
	
	public newJLayer() {
		this.setBounds(0, 0, 1200, 850);
		timer = new Timer(10000, this); 
		timer.start();
	}
	
	public void paint(Graphics g) { 
		Graphics2D g1 = (Graphics2D) g;
		for(List<newPeople> person : getPeoples) {
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
