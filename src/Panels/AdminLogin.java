package Panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Commands.Commands;
import Main.Main;
import Vars.Vars;

public class AdminLogin {

	public static JPanel panel = new JPanel();

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(new Color(50, 70, 100));

		JPasswordField passFieldPassword = new JPasswordField();
		passFieldPassword.setBounds(Vars.halfScreenWidth - 150, Vars.halfScreenHeight, 300, 20);
		passFieldPassword.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (passFieldPassword.getText().equals(Vars.MasterPassword)) {
					Commands.switchPanels(Main.panelAdminLogin, Main.panelAdminSettings);
				} else {
					Main.MainFrame.dispose();
				}
			}
		});
		panel.add(passFieldPassword);
	}
}
