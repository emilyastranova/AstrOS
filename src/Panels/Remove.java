package Panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Commands.Commands;
import HomePanels.Ticket;
import Main.MenuItem;
import Vars.Vars;

public class Remove {

	public static JPanel panel = new JPanel();
	public static ArrayList<JTextField> removeItems;
	public static int selectedIndex = 0;

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Vars.colorMainBG);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(5, 5, (Vars.dimensionFullScreen.width / 3) + 20, Vars.dimensionFullScreen.height);
		panel.add(scrollPane);
		
		removeItems = new ArrayList<JTextField>();
		for (int i = 0; i < Ticket.ticketText.size(); i++) {
			removeItems.add(Commands.createRemoveItem(Ticket.ticketText.get(i), 5 + (i * 20)));
			scrollPane.add(removeItems.get(i));
		}
		
		if (!removeItems.isEmpty()) {
			removeItems.get(selectedIndex).setBackground(Vars.colorDefaultSelected);
		}
		
		MenuItem buttonUp = new MenuItem(Vars.colorDefualtButton, Vars.colorDefaultFont);
		buttonUp.setBounds((Vars.dimensionFullScreen.width / 3) + 40, 5, 100, 100);
		buttonUp.setFont(Commands.changeFontSize(25));
		buttonUp.setText(Commands.buttonText("/\\<br>|<br>Up", "50px"));
		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedIndex != 0) {
					selectedIndex -= 1;
				}
				for (int i = 0; i < removeItems.size(); i++) {
					removeItems.get(i).setBackground(null);
				}
				removeItems.get(selectedIndex).setBackground(Vars.colorDefaultSelected);
			}
		}); 
		panel.add(buttonUp);
		
		MenuItem buttonDown = new MenuItem(Vars.colorDefualtButton, Vars.colorDefaultFont);
		buttonDown.setBounds((Vars.dimensionFullScreen.width / 3) + 40, 110, 100, 100);
		buttonDown.setFont(Commands.changeFontSize(25));
		buttonDown.setText(Commands.buttonText("Down<br>|<br>\\/", "50px"));
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedIndex != removeItems.size() - 1) {
					selectedIndex += 1;
				}
				for (int i = 0; i < removeItems.size(); i++) {
					removeItems.get(i).setBackground(null);
				}
				removeItems.get(selectedIndex).setBackground(Vars.colorDefaultSelected);
			}
		});
		panel.add(buttonDown);
		
		MenuItem buttonRemove = new MenuItem(new Color(255, 0, 0), Vars.colorDefaultFont);
		buttonRemove.setBounds((Vars.dimensionFullScreen.width / 3) + 40, 215, 100, 100);
		buttonRemove.setFont(Commands.changeFontSize(20));
		buttonRemove.setText(Commands.buttonText("Remove<br>X", "50px"));
		buttonRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(buttonRemove);
		
		MenuItem buttonFinished = new MenuItem(Vars.colorDefualtButton, Vars.colorDefaultFont);
		buttonFinished.setMargin(new Insets(0, 0, 0, 0));
		buttonFinished.setBounds((Vars.dimensionFullScreen.width / 3) + 40, 320, 100, 100);
		buttonFinished.setFont(Commands.changeFontSize(20));
		buttonFinished.setText("Finished");
		buttonFinished.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(buttonFinished);
		
		panel.setBounds(0, 0, Vars.dimensionFullScreen.width, Vars.dimensionFullScreen.height);
	}

}
