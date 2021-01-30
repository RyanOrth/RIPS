package Frontend;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class MapGenerator extends JFrame {
	
	public MapGenerator() {
		JPanel panel = new JPanel();
	    getContentPane().add(panel);
	    setSize(550, 700);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	    Graphics2D g2 = (Graphics2D) g;
	    Line2D line = new Line2D.Double(50, 650, 50, 50);
	    g2.draw(line);
	}
	
	public static void main(String args[]) {
		MapGenerator map = new MapGenerator();
		map.setVisible(true);
	}
}