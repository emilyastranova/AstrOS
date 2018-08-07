package Panels;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import Commands.Commands;
import HomePanels.Ticket;
import Main.Main;
import Main.MenuItemButton;
import Vars.LocalSQL;
import Vars.Vars;

public class Add{

	public static JPanel panel = new JPanel();
	public static String table = "Opt_ALL";
	public static ArrayList<ArrayList<String>> items;
	public static MenuItemButton buttonFinished;

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Vars.colorMainBG);
		
		
		buttonFinished = new MenuItemButton(Vars.colorDefaultButton, Vars.colorDefaultFont);
		buttonFinished.setText("Finished");
		buttonFinished.setFont(Commands.changeFontSize(15));
		buttonFinished.setBounds(Vars.dimensionFullScreen.width - 400, Vars.dimensionFullScreen.height - 90, 100, 50);
		buttonFinished.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Commands.switchPanels(Main.panelAdd, Main.panelHome);
				Home.panel.add(Ticket.panel);
			}
			
		});
		panel.add(buttonFinished);
		
		items = LocalSQL.Opt_ALL;

		ArrayList<MenuItemButton> itemButtons = new ArrayList<MenuItemButton>();
		for (int i = 0; i < (items.size() / 9) + 1; i++) {
			for (int j = 0; j < 9; j++) {
				int currentIndex = (i * 9) + j;
				if (!(currentIndex >= items.size())) {
					itemButtons.add(Commands.createOptionItemButton(items.get(currentIndex).get(0), 5 + (j * 100), 5 + (i * 105)));
					itemButtons.get(currentIndex).setPrice(Double.parseDouble(items.get(currentIndex).get(1)));
					String nameOfOption = items.get(currentIndex).get(0);
					String priceOfItem = items.get(currentIndex).get(1);
					itemButtons.get(currentIndex).addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Commands.addToTicket(Commands.ticketSpacing(nameOfOption, Double.parseDouble(priceOfItem), true),Double.parseDouble(priceOfItem));
						}
					});
					panel.add(itemButtons.get(currentIndex));
				}
			}
		}
		panel.setBounds(0, 0, Vars.dimensionFullScreen.width, Vars.dimensionFullScreen.height);
	}

}
