package AdminPanels;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuItems {
	public static JPanel panel = new JPanel();
	
	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Color.GREEN);
		
		JLabel label = new JLabel("TEST");
		label.setBounds(50, 50, 200, 50);
		panel.add(label);
	}

}
