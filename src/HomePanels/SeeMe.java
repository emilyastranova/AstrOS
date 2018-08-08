package HomePanels;

import java.awt.Graphics;

import javax.swing.JPanel;

import Vars.Vars;

public class SeeMe {
	public static JPanel panel = new JPanel();
	
	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Vars.colorMainBG);
		
		panel.setBounds(0, 0, Vars.dimensionFullScreen.width, Vars.dimensionFullScreen.height);
	}
	
}
