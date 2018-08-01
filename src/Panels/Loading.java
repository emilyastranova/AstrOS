package Panels;

import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Vars.Vars;

public class Loading {
	public static JPanel panel = new JPanel();
	
	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Vars.colorMainBG);
		
		JLabel labelLoading = new JLabel("Loading...");
		labelLoading.setHorizontalAlignment(JLabel.CENTER);
		labelLoading.setFont(Vars.fontDefault);
		labelLoading.setBounds(Vars.halfScreenWidth - 50, Vars.halfScreenHeight - 40, 100, 80);
		panel.add(labelLoading);
	}
}
