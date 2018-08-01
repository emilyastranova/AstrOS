package HomePanels.OptionsPanels;

import java.awt.Graphics;

import javax.swing.JPanel;

import Vars.Vars;

public class Blank {

	public static JPanel panel = new JPanel();
	
	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(null);
		
		panel.setBounds(5, 5, (Vars.dimensionFullScreen.width * 2/3) - 5, Vars.dimensionFullScreen.height / 3 - 5);
	}
	
}
