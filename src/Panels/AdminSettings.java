package Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import AdminPanels.AdminButton;
import AdminPanels.Login;
import AdminPanels.MenuItems;
import AdminPanels.Options;
import Vars.Vars;

public class AdminSettings {

	public static JPanel panel = new JPanel();
	public static JPanel panelLogin;
	public static JPanel panelMenuItems;
	public static JPanel panelOptions;

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(new Color(20,20,24));
		
		JLabel labelLogin = new JLabel("Login");
		labelLogin.setFont(Vars.fontDefault);
		labelLogin.setForeground(Color.WHITE);
		labelLogin.setHorizontalAlignment(JLabel.CENTER);
		labelLogin.setBounds(Vars.dimensionFullScreen.width /6 - 100, 10, 200, 100);
		labelLogin.setFont(new Font("Roboto",Font.PLAIN, 35));
		panel.add(labelLogin);
		
		JLabel labelMenuItems = new JLabel("Menu Items");
		labelMenuItems.setFont(Vars.fontDefault);
		labelMenuItems.setForeground(Color.WHITE);
		labelMenuItems.setHorizontalAlignment(JLabel.CENTER);
		labelMenuItems.setBounds(Vars.dimensionFullScreen.width /2 - 100, 10, 200, 100);
		labelMenuItems.setFont(new Font("Roboto",Font.PLAIN, 35));
		panel.add(labelMenuItems);
		
		JLabel labelOptions = new JLabel("Options");
		labelOptions.setFont(Vars.fontDefault);
		labelOptions.setForeground(Color.white);
		labelOptions.setHorizontalAlignment(JLabel.CENTER);
		labelOptions.setBounds(Vars.dimensionFullScreen.width * 5/6 - 100, 10, 200, 100);
		labelOptions.setFont(new Font("Roboto",Font.PLAIN, 35));
		panel.add(labelOptions);
		
		panelLogin = new Login();
		panelMenuItems = new MenuItems();
		panelOptions = new Options();
		
		
		JScrollPane scrollLogin = new JScrollPane(panelLogin);
		scrollLogin.setBorder(null);
		scrollLogin.setBounds(0, 100, Vars.dimensionFullScreen.width / 3, Vars.dimensionFullScreen.height - 200);
		scrollLogin.getVerticalScrollBar().setUnitIncrement(16);
		scrollLogin.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollLogin.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollLogin);

		JScrollPane scrollMenuItems = new JScrollPane(panelMenuItems);
		scrollMenuItems.setBorder(null);
		scrollMenuItems.setBounds(Vars.dimensionFullScreen.width / 3, 100, Vars.dimensionFullScreen.width / 3, Vars.dimensionFullScreen.height - 100);
		scrollMenuItems.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollMenuItems.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollMenuItems.getVerticalScrollBar().setUnitIncrement(16);
		panel.add(scrollMenuItems);		
		
		JScrollPane scrollOptions = new JScrollPane(panelOptions);
		scrollOptions.setBorder(null);
		scrollOptions.setBounds(Vars.dimensionFullScreen.width * 2/3, 100, Vars.dimensionFullScreen.width / 3, Vars.dimensionFullScreen.height - 100);
		scrollOptions.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollOptions.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollOptions.getVerticalScrollBar().setUnitIncrement(16);
		panel.add(scrollOptions);
		
		AdminButton buttonRemove = new AdminButton();
	}
}
