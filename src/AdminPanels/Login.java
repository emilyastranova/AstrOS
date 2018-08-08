package AdminPanels;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Login {
	public static JPanel panel = new JPanel();
	
	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Color.YELLOW);
		
		JLabel label = new JLabel("TEST");
		label.setBounds(50, 50, 200, 50);
		panel.add(label);
	}

}
