package Frontend;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MapGenerator extends JFrame {
	private static JFrame pane = new JFrame();
	
	public static void main(String args[]) {
		pane.setPreferredSize(new Dimension(300, 400));
		pane.pack();
		pane.setVisible(true);
	}
}