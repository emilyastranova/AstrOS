package Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Vars.Vars;

public class AdminSettings {

	public static JPanel panel = new JPanel();
	public static JPanel panelLogin = new JPanel();
	public static JPanel panelMenuItems = new JPanel();
	public static JPanel panelOptions = new JPanel();

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Vars.colorMainBG);
		
		JLabel labelLogin = new JLabel("Login");
		labelLogin.setFont(Vars.fontDefault);
		labelLogin.setHorizontalAlignment(JLabel.CENTER);
		labelLogin.setBounds(Vars.dimensionFullScreen.width /6 - 100, 10, 200, 100);
		panel.add(labelLogin);
		
		JLabel labelMenuItems = new JLabel("Menu Items");
		labelMenuItems.setFont(Vars.fontDefault);
		labelMenuItems.setHorizontalAlignment(JLabel.CENTER);
		labelMenuItems.setBounds(Vars.dimensionFullScreen.width /2 - 100, 10, 200, 100);
		panel.add(labelMenuItems);
		
		JLabel labelOptions = new JLabel("Options");
		labelOptions.setFont(Vars.fontDefault);
		labelOptions.setHorizontalAlignment(JLabel.CENTER);
		labelOptions.setBounds(Vars.dimensionFullScreen.width * 5/6 - 100, 10, 200, 100);
		panel.add(labelOptions);

		createPanelLogin(g);
		createPanelMenuItems(g);
		createPanelOptions(g);		
		
		JScrollPane scrollLogin = new JScrollPane(panelLogin);
		scrollLogin.setBounds(0, 100, Vars.dimensionFullScreen.width / 3, Vars.dimensionFullScreen.height - 100);
		scrollLogin.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollLogin.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollLogin);

		JScrollPane scrollMenuItems = new JScrollPane(panelMenuItems);
		scrollMenuItems.setBounds(Vars.dimensionFullScreen.width / 3, 100, Vars.dimensionFullScreen.width / 3, Vars.dimensionFullScreen.height - 100);
		scrollMenuItems.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollMenuItems.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollMenuItems);		
		
		JScrollPane scrollOptions = new JScrollPane(panelOptions);
		scrollOptions.setBounds(Vars.dimensionFullScreen.width * 2/3, 100, Vars.dimensionFullScreen.width / 3, Vars.dimensionFullScreen.height - 100);
		scrollOptions.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollOptions.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollOptions);
		
	}
	
	public static void createPanelLogin(Graphics g) {
		panelLogin.setLayout(null);
		panelLogin.setBackground(Color.YELLOW);
		
		JLabel label = new JLabel("TEST");
		label.setBounds(50, 50, 200, 50);
		panelLogin.add(label);
	}
	
	public static void createPanelMenuItems(Graphics g) {
		panelMenuItems.setLayout(null);
		panelMenuItems.setBackground(Color.GREEN);
		
		JLabel label = new JLabel("TEST");
		label.setBounds(50, 50, 200, 50);
		panelMenuItems.add(label);
	}
	
	public static void createPanelOptions(Graphics g) {
		panelOptions.setLayout(null);
		panelOptions.setBackground(Color.RED);
		
		JLabel label = new JLabel("TEST");
		label.setBounds(50, 50, 200, 50);
		panelOptions.add(label);
	}
}
