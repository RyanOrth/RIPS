package Backend;

import javax.swing.JFrame;

public class newFrame extends JFrame{
	NewPanel panel; 
	public newFrame() {
		panel = new NewPanel(); 
		newJLayer layer = new newJLayer();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);	
		this.add(layer);
	}
	
}
