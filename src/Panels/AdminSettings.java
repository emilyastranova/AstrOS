package Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
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

		createPanelLogin(g);
		createPanelMenuItems(g);
		createPanelOptions(g);		
		
		JScrollPane scrollLogin = new JScrollPane();
		scrollLogin.setPreferredSize(new Dimension(Vars.dimensionFullScreen.width / 3, Vars.dimensionFullScreen.height));
		scrollLogin.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollLogin.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollLogin.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		scrollLogin.add(panelLogin);
		panel.add(scrollLogin);
	}
	
	public static void createPanelLogin(Graphics g) {
		panelLogin.setLayout(null);
		panelLogin.setBackground(Color.BLACK);
		
		panelLogin.setBounds(0, 0, Vars.dimensionFullScreen.width / 3, Vars.dimensionFullScreen.height);
	}
	
	public static void createPanelMenuItems(Graphics g) {
		panelMenuItems.setLayout(null);
		panelMenuItems.setBackground(Vars.colorMainBG);
		
		panelMenuItems.setBounds(Vars.dimensionFullScreen.width / 3, 0, Vars.dimensionFullScreen.width / 3, Vars.dimensionFullScreen.height);
	}
	
	public static void createPanelOptions(Graphics g) {
		panelOptions.setLayout(null);
		panelOptions.setBackground(Vars.colorMainBG);
		
		panelOptions.setBounds(Vars.dimensionFullScreen.width * 2/3, 0, Vars.dimensionFullScreen.width / 3, Vars.dimensionFullScreen.height);
	}
}
