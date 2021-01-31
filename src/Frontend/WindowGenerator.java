package Frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Backend.InfectionType;
import Backend.PersonBehavior;
import Backend.SafetyMeasures;
import Backend.SimLogic;

import javax.swing.JButton;
import javax.swing.JFrame;

import Backend.SimLogic.*;

public class WindowGenerator extends JFrame {
	private JTextField peopleField = new JTextField("Enter number of people here."); //Enter number of people here.
	private JTextField infectionField = new JTextField("Enter number of people here."); //Enter infection status here. (\"infected\" or \"not infected\")
	private JTextField maskField = new JTextField("Enter number of people here."); //Enter mask status here. (\"mask\" or \"no mask\")
	private Integer numPeople;
	private String infectionStatus;
	private String maskStatus;
	
	public WindowGenerator() {
		JPanel panel = new JPanel();
		JButton submit = new JButton("Submit");
		submit.setBounds(1000, 400, 20, 20);
		peopleField.setBounds(900, 100, 40, 20);
		infectionField.setBounds(920, 100, 40, 20);
		maskField.setBounds(940, 100, 40, 20);
		panel.add(submit);
		panel.add(peopleField);
		panel.add(infectionField);
		panel.add(maskField);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					numPeople = Integer.valueOf(peopleField.getText());
					if(infectionField.getText().equals("infected") || infectionField.getText().equals("not infected")) {
						infectionStatus = infectionField.getText();
					} else {
						clearEntry();
						return;
					}
					if(maskField.getText().equals("mask") || maskField.getText().equals("no mask")) {
						maskStatus = maskField.getText();
					} else {
						clearEntry();
						return;
					}
				} catch (IllegalArgumentException j) {
					clearEntry();
					return;
				}
				System.out.println(numPeople + "\n" + infectionStatus + "\n" + maskStatus);
			}
		});
	    getContentPane().add(panel);
	    setMinimumSize(new Dimension(1100, 700));
	}
	
	public void clearEntry() {
		peopleField.setText("");
		infectionField.setText("");
		maskField.setText("");
	}
	
	public static Graphics2D g2;
	
	public void paint(Graphics g) {
		super.paint(g);
		//Graphics2D g2 = (Graphics2D) g;
		g2 = (Graphics2D) g;
		
	    for(int i=50; i <= 800; i+=50) {
	    	Line2D line = new Line2D.Double(i, 800, i, 50);
	    	g2.draw(line);
	    }
	    for(int v=800; v >=50 ; v-=50) {
	    	Line2D line= new Line2D.Double(50, v, 800, v);
	    	g2.draw(line);
	    }
	    
	    for(int i = 0; i < 25; i++) {
			int posX = SimLogic.genRanCoord();
			int posY = SimLogic.genRanCoord();
			
			InfectionType infectionStatusValue = SimLogic.infectionStatus[SimLogic.randStatus()];
			SafetyMeasures safetyMeasuresValue = SimLogic.safetyMeasureStatus[SimLogic.randStatus()];
			
			//System.out.println("In SimLogic paint method just before person.add");
			SimLogic.person.add(new PersonBehavior(posX, posY, infectionStatusValue, safetyMeasuresValue, g2));
			
			System.out.println("Location (" + posX + ", " + posY + "), Infection Type: " + infectionStatusValue + ", Safety Measures: " + safetyMeasuresValue);
		}
	    
	    //Line2D line = new Line2D.Double(25, 0, 25, 28);
	    //g2.draw(line);
	    
		//generatePersonGraphics(2,2, SafetyMeasures.NO_MASK, InfectionType.INFECTED);
	}
	
	public static void generatePersonGraphics(double xPos, double yPos, SafetyMeasures safetyMeasures, InfectionType infectionType) {
		//System.out.println("In generate person graphics");
		
		System.out.print("(" + xPos + ", " + yPos + ")");
		
		xPos *= 50;
		xPos += 50;
		yPos *= 50;
		yPos += 50;
		if(infectionType == InfectionType.INFECTED) {
			g2.setColor(Color.RED);
			//System.out.println("Background set to red");
		}else {
			g2.setColor(Color.BLUE);
			//System.out.println("Background set to blue");
		}
		if(safetyMeasures == SafetyMeasures.WEARING_MASK) {
			g2.fill(new Ellipse2D.Double(xPos - 6, yPos - 6, 12, 12));
			System.out.println("Wearing Mask, draw eclipse");
		}else {
			/*g2.draw(new Polygon(new int[] {((int) xPos-20), (int) xPos, ((int) xPos + 20)}, 
				new int[] {((int)yPos), ((int)yPos + 50), ((int)yPos)}, 3));*/
			//g2.setColor(Color.red);
			g2.fill(new Polygon(new int[] {((int) xPos-10), (int) xPos, ((int) xPos + 10)}, 
				new int[] {((int)yPos + 7), ((int)yPos - 12), ((int)yPos + 7)}, 3));
			//System.out.println("Triangle time!!!!");
		}
		if(safetyMeasures == SafetyMeasures.WEARING_MASK) {
			g2.setColor(new Color(203, 206, 212, 127));
			//System.out.println("Here's ye backgroun colour");
		}else {
			g2.setColor(new Color(128, 255, 0, 127));
			//System.out.println("More background colors for ya");
		}
		if(infectionType == InfectionType.INFECTED) {
			if(safetyMeasures == SafetyMeasures.WEARING_MASK) {
				g2.fill(new Ellipse2D.Double(xPos - 9, yPos - 9, 18, 18));
				//System.out.println("Should be drawn by now");
			}else {
				g2.fill(new Ellipse2D.Double(xPos - 12, yPos - 12, 24, 24));
				//System.out.println("Or maybe now");
			}
		}else {
			g2.fill(new Ellipse2D.Double(xPos, yPos, 0, 0));
			//System.out.println("This is ye last shot matey!!!");
		}
	}
	
	public static void main(String args[]) {
		WindowGenerator map = new WindowGenerator();
		map.setVisible(true);
		//System.out.println("Completed WinGen main method");
	}
}