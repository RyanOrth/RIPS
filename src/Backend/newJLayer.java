package Backend;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.Timer;

public class newJLayer extends JLayeredPane implements ActionListener{
	Timer timer; 
	public newJLayer() {
		this.setBounds(0, 0, 1200, 850);
		timer = new Timer(10000, this); 
		timer.start();
	}
	
	public void paint(Graphics g) { 
		Graphics2D g1 = (Graphics2D) g; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
