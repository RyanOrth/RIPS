package Backend;

import javax.swing.JFrame;

public class newFrame extends JFrame{
	NewPanel panel; 
	public newFrame() {
		panel = new NewPanel(); 
		newJLayer layer = new newJLayer();

		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.add(layer);

		this.pack();
		
		this.setLocationRelativeTo(null);
		this.setSize(1500, 1500);
		this.setVisible(true);	
	}
	
	public static void main(String[] args) {
		new newFrame();
	}
	
}
