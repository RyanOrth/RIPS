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
	    setSize(800, 700);
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
		MapGenerator map = new MapGenerator();
		map.setVisible(true);
	}
}