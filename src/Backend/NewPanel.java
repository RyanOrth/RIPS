package Backend;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class NewPanel extends JPanel{

	public NewPanel() {
		this.setBounds(0, 0, 1200, 800);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g; 
		//Graphics2D g2 = (Graphics2D) g;
		g2 = (Graphics2D) g;
		
	    for(int i=50; i <= 800; i+=50) {
	    	Line2D line = new Line2D.Double(i, 800, i, 50);
	    	g2.draw(line);
	    }
	    for(int v= 800; v >=50 ; v-=50) {
	    	Line2D line= new Line2D.Double(50, v, 800, v);
	    	g2.draw(line);
	    }
	}
}
