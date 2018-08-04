package Panels;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Commands.Commands;
import Commands.SQL;
import HomePanels.Ticket;
import Main.MenuItem;
import Vars.Vars;

public class Add {

	public static JPanel panel = new JPanel();
	public static String table = "Opt_ALL";
	public static ArrayList<String> items;
	public static ArrayList<String> tables;

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Vars.colorMainBG);

		tables = SQL.returnAllContents();

		if (tables.contains(table)) {
			items = SQL.returnTableContents(table, "Options");
		} else {
			items = new ArrayList<String>();
		}

		panel.removeAll();
		ArrayList<MenuItem> itemButtons = new ArrayList<MenuItem>();
		for (int i = 0; i < (items.size() / 9) + 1; i++) {
			for (int j = 0; j < 9; j++) {
				int currentIndex = (i * 9) + j;
				if (!(currentIndex >= items.size())) {
					itemButtons.add(Commands.createOptionItemButton(items.get(currentIndex), 5 + (j * 100), 5 + (i * 105)));

					String nameOfOption = items.get(currentIndex);
					itemButtons.get(currentIndex).addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Commands.add2Ticket(Commands.ticketSpacing(nameOfOption, Double.parseDouble(SQL.returnPriceOfOption(table, nameOfOption)), true));
						}
					});
					panel.add(itemButtons.get(currentIndex));
				}
			}
			/*
			 * if (i < 8) { itemButtons.add(Commands.createOptionItemButton(items.get(i), 5
			 * + (i * 100), 5)); } else {
			 * itemButtons.add(Commands.createOptionItemButton(items.get(i), 5 + ((i - 8) *
			 * 100), 110)); } String nameOfOption = items.get(i);
			 * itemButtons.get(i).addActionListener(new ActionListener() { public void
			 * actionPerformed(ActionEvent e) {
			 * Commands.add2Ticket(Commands.ticketSpacing(nameOfOption,
			 * Double.parseDouble(SQL.returnPriceOfOption(table, nameOfOption)), true)); }
			 * }); panel.add(itemButtons.get(i));
			 */
		}

		panel.setBounds(0, 0, Vars.dimensionFullScreen.width, Vars.dimensionFullScreen.height);
	}

}