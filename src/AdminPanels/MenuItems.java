package AdminPanels;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuItems extends JPanel {
	
	public MenuItems() {
		setLayout(null);
		setBackground(Color.white);
		
		JLabel label = new JLabel("TEST");
		label.setBounds(50, 50, 200, 50);
		add(label);
	}

}
