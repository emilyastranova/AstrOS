package Panels;

import java.awt.Graphics;

import javax.swing.JPanel;

import Commands.Commands;
import Vars.Vars;

public class AdminSettings {

	public static JPanel panel = new JPanel();

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Vars.colorMainBG);
	}
}
