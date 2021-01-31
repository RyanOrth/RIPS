package Frontend;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

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
	
	public void paint(Graphics g) {
		super.paint(g);
	    Graphics2D g2 = (Graphics2D) g;
	    for(int i=20; i <= 800; i+=50) {
	    	Line2D line = new Line2D.Double(i, 650, i, 58);
	    	g2.draw(line);
	    }
	    for(int v=650; v >=50 ; v-=37) {
	    	Line2D line= new Line2D.Double(20, v, 770, v);
	    	g2.draw(line);
	    }
	}
	
	public static void main(String args[]) {
		WindowGenerator map = new WindowGenerator();
		map.setVisible(true);
	}
}