package HomePanels.OptionsPanels;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Commands.Commands;
import Vars.Vars;

public class Breadsticks {

	public static JPanel panel = new JPanel();
	
	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(null);

		JButton buttonOption1 = Commands.createOptionItemButton("Marinara Sauce", 5, 5);
		panel.add(buttonOption1);
		JButton buttonOption2 = Commands.createOptionItemButton("Alfredo Sauce", 160, 5);
		panel.add(buttonOption2);
		JButton buttonOption3 = Commands.createOptionItemButton("No Sauce", 315, 5);
		panel.add(buttonOption3);
		
		panel.setBounds(5, 5, (Vars.dimensionFullScreen.width * 2/3) - 5, Vars.dimensionFullScreen.height / 3 - 5);
	}
	
}
