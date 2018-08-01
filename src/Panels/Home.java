package Panels;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Commands.Commands;
import HomePanels.Appetizers;
import HomePanels.CustomColorButton;
import HomePanels.Desserts;
import HomePanels.Entrees;
import HomePanels.Options;
import HomePanels.Pizza;
import HomePanels.Ticket;
import Vars.Vars;

public class Home {
	public static JPanel panel = new JPanel();
	
	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Vars.colorMainBG);
		Appetizers.createView(g);
		Entrees.createView(g);
		Pizza.createView(g);
		Desserts.createView(g);
		Ticket.createView(g);
		Options.createView(g);
		
		CustomColorButton buttonHeadAppetizers = Commands.createHeaderButton("Appetizers", 5, Vars.colorDefaultHeaderButton);
		CustomColorButton buttonHeadEntrees = Commands.createHeaderButton("Misc. Entrees", 215, Vars.colorDefaultHeaderButton);
		CustomColorButton buttonHeadPizza = Commands.createHeaderButton("Pizza", 425, Vars.colorDefaultHeaderButton);
		CustomColorButton buttonHeadDesserts = Commands.createHeaderButton("Desserts", 635, Vars.colorDefaultHeaderButton);
		buttonHeadAppetizers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.remove(Entrees.panel);
				panel.remove(Pizza.panel);
				panel.remove(Desserts.panel);
				panel.add(Appetizers.panel);
				buttonHeadEntrees.setBackground(Vars.colorDefaultHeaderButton);
				buttonHeadPizza.setBackground(Vars.colorDefaultHeaderButton);
				buttonHeadDesserts.setBackground(Vars.colorDefaultHeaderButton);
				buttonHeadAppetizers.setBackground(Vars.colorDefaultHeaderButtonSelected);
				panel.setVisible(false);
				panel.setVisible(true);
			}
		});
		buttonHeadAppetizers.setBackground(Vars.colorDefaultHeaderButtonSelected);
		panel.add(buttonHeadAppetizers);
		buttonHeadEntrees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.remove(Appetizers.panel);
				panel.remove(Pizza.panel);
				panel.remove(Desserts.panel);
				panel.add(Entrees.panel);
				buttonHeadAppetizers.setBackground(Vars.colorDefaultHeaderButton);
				buttonHeadPizza.setBackground(Vars.colorDefaultHeaderButton);
				buttonHeadDesserts.setBackground(Vars.colorDefaultHeaderButton);
				buttonHeadEntrees.setBackground(Vars.colorDefaultHeaderButtonSelected);
				panel.setVisible(false);
				panel.setVisible(true);
			}
		});
		panel.add(buttonHeadEntrees);
		buttonHeadPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.remove(Appetizers.panel);
				panel.remove(Entrees.panel);
				panel.remove(Desserts.panel);
				panel.add(Pizza.panel);
				buttonHeadAppetizers.setBackground(Vars.colorDefaultHeaderButton);
				buttonHeadEntrees.setBackground(Vars.colorDefaultHeaderButton);
				buttonHeadDesserts.setBackground(Vars.colorDefaultHeaderButton);
				buttonHeadPizza.setBackground(Vars.colorDefaultHeaderButtonSelected);
				panel.setVisible(false);
				panel.setVisible(true);
			}
		});
		panel.add(buttonHeadPizza);
		buttonHeadDesserts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.remove(Appetizers.panel);
				panel.remove(Pizza.panel);
				panel.remove(Entrees.panel);
				panel.add(Desserts.panel);
				buttonHeadAppetizers.setBackground(Vars.colorDefaultHeaderButton);
				buttonHeadPizza.setBackground(Vars.colorDefaultHeaderButton);
				buttonHeadEntrees.setBackground(Vars.colorDefaultHeaderButton);
				buttonHeadDesserts.setBackground(Vars.colorDefaultHeaderButtonSelected);
				panel.setVisible(false);
				panel.setVisible(true);
			}
		});
		panel.add(buttonHeadDesserts);
		
		panel.add(Options.panel);
		panel.add(Appetizers.panel);
		panel.add(Ticket.panel);
	}	
}
