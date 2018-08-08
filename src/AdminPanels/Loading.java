package AdminPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.Main;
import Vars.Vars;

public class Loading extends JFrame{
	public static JPanel panel = new JPanel();
	
	public Loading() {
		panel.setLayout(null);
		panel.setBackground(new Color(20,20,24));

		JLabel labelLoading = new JLabel("Please wait...");
		labelLoading.setHorizontalAlignment(JLabel.CENTER);
		labelLoading.setFont(Vars.fontDefault);
		labelLoading.setBounds(0, 0, 400, 120);
		labelLoading.setFont(Vars.fontGoogle);
		labelLoading.setForeground(Color.white);
		panel.setVisible(true);
		panel.add(labelLoading);
		
		add(panel);
		setSize(new Dimension(400,150));
		Main.centerWindow(this);
		setTitle("Making changes...");
		setVisible(true);
	}
	
}
