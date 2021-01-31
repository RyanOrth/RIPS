package Frontend;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.Box;
import javax.swing.BoxLayout;

import Backend.InfectionType;
import Backend.PersonBehavior;
import Backend.SafetyMeasures;
import Backend.SimLogic;
import Backend.InfectionType;
import Backend.SafetyMeasures;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WindowGenerator extends JFrame implements ActionListener{
	private JTextField peopleField = new JTextField("");
	private JTextField infoForPeopleField = new JTextField("Enter total number of people below:");
	private JTextField infectionField = new JTextField("");
	private JTextField infoForInfectionField = new JTextField("Enter percentage of infected/not infected below:");
	private JTextField maskField = new JTextField("");
	private JTextField infoForMaskField = new JTextField("Enter percentage of masked/not masked below:");
	private Integer numPeople;
	private Integer infectionStatus;
	private Integer maskStatus;
	Timer timer; 
	public List<PersonBehavior> createPersonList() { 
		for(int i = 0; i < 25; i++) {
			int posX = SimLogic.genRanCoord();
			int posY = SimLogic.genRanCoord();
			
			InfectionType infectionStatusValue = SimLogic.infectionStatus[(int)(Math.random() * 2)];
			SafetyMeasures safetyMeasuresValue = SimLogic.safetyMeasureStatus[(int)(Math.random() * 2)];
			
			SimLogic.person.add(new PersonBehavior(posX, posY, infectionStatusValue, safetyMeasuresValue, g2));
			
			System.out.println("Location (" + posX + ", " + posY + "), Infection Type: " + infectionStatusValue + ", Safety Measures: " + safetyMeasuresValue);
		}
	
		return SimLogic.person; 
	} 
	
	public WindowGenerator() {
		timer = new Timer(100, this); 
		timer.start(); 
		
		JPanel panel = new JPanel();
		JPanel inputPanel = new JPanel();
		JButton submit = new JButton("Submit");
		submit.setMaximumSize(new Dimension(200, 75));
		peopleField.setMaximumSize(new Dimension(600, 75));
		infectionField.setMaximumSize(new Dimension(600, 75));
		maskField.setMaximumSize(new Dimension(600, 75));
		infoForPeopleField.setMaximumSize(new Dimension(600, 75));
		infoForInfectionField.setMaximumSize(new Dimension(600, 75));
		infoForMaskField.setMaximumSize(new Dimension(600, 75));
		infoForPeopleField.setEditable(false);
		infoForInfectionField.setEditable(false);
		infoForMaskField.setEditable(false);
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		inputPanel.add(Box.createHorizontalStrut(150));
		inputPanel.add(infoForPeopleField);
		inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		inputPanel.add(peopleField);
		inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		inputPanel.add(Box.createHorizontalStrut(300));
		inputPanel.add(infoForInfectionField);
		inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		inputPanel.add(infectionField);
		inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		inputPanel.add(Box.createHorizontalStrut(300));
		inputPanel.add(infoForMaskField);
		inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		inputPanel.add(maskField);
		inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		inputPanel.add(Box.createHorizontalStrut(300));
		inputPanel.add(submit);
		inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		inputPanel.add(Box.createHorizontalStrut(150));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					numPeople = Integer.valueOf(peopleField.getText());
					infectionStatus = Integer.valueOf(infectionField.getText());
					maskStatus = Integer.valueOf(maskField.getText());
					System.out.println(numPeople + "\n" + infectionStatus + "\n" + maskStatus);
				} catch (IllegalArgumentException j) {
					JOptionPane.showMessageDialog(null, "Please only enter a numerical value for these entries.");
					clearEntry();
					return;
				}
			}
		});
	    Container contentPane = getContentPane();
	    contentPane.add(panel, BorderLayout.CENTER);
	    contentPane.add(inputPanel, BorderLayout.EAST);
	    setMinimumSize(new Dimension(1200, 850));
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
	    
	    
	    
	    //Line2D line = new Line2D.Double(25, 0, 25, 28);
	    //g2.draw(line);
	    
		//generatePersonGraphics(2,2, SafetyMeasures.NO_MASK, InfectionType.INFECTED);
	}
	
	public static void generatePersonGraphics(double xPos, double yPos, SafetyMeasures safetyMeasures, InfectionType infectionType) {				
		xPos *= 50;
		xPos += 50;
		yPos *= 50;
		yPos += 50;
		
		if(infectionType == InfectionType.INFECTED) {
			g2.setColor(Color.RED);
		}else {
			g2.setColor(Color.BLUE);
		}
		if(safetyMeasures == SafetyMeasures.WEARING_MASK) {
			g2.fill(new Ellipse2D.Double(xPos - 6, yPos - 6, 12, 12));
		}else {
			/*g2.draw(new Polygon(new int[] {((int) xPos-20), (int) xPos, ((int) xPos + 20)}, 
				new int[] {((int)yPos), ((int)yPos + 50), ((int)yPos)}, 3));*/
			//g2.setColor(Color.red);
			g2.fill(new Polygon(new int[] {((int) xPos-10), (int) xPos, ((int) xPos + 10)}, 
				new int[] {((int)yPos + 7), ((int)yPos - 12), ((int)yPos + 7)}, 3));
		}
		if(safetyMeasures == SafetyMeasures.WEARING_MASK) {
			g2.setColor(new Color(203, 206, 212, 127));
		}else {
			g2.setColor(new Color(128, 255, 0, 127));
		}
		if(infectionType == InfectionType.INFECTED) {
			if(safetyMeasures == SafetyMeasures.WEARING_MASK) {
				g2.fill(new Ellipse2D.Double(xPos - 9, yPos - 9, 18, 18));
			}else {
				g2.fill(new Ellipse2D.Double(xPos - 12, yPos - 12, 24, 24));
			}
		}else {
			g2.fill(new Ellipse2D.Double(xPos, yPos, 0, 0));
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==timer) { 
			repaint(); 
		}
	}
	
	public static void main(String args[]) {
		WindowGenerator map = new WindowGenerator();
		map.setVisible(true);
	}

}