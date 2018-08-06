package HomePanels.OptionsPanels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import Commands.Commands;
import Commands.SQL;
import Main.MenuItemButton;
import Vars.Vars;

public class OptionPanel {

	public static JPanel panel = new JPanel();
	public static String nameOfItem = "NOTHING";
	public static ArrayList<String> items;
	public static ArrayList<String> tables;

	public static void setNameOfItem(String n) {
		nameOfItem = n;
	}

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(null);
		
		panel.setBounds(5, 5, (Vars.dimensionFullScreen.width * 2 / 3) - 5, Vars.dimensionFullScreen.height / 3 - 5);
	}

	public static void updatePanel() {
		tables = SQL.returnAllContents();
		
		if (!nameOfItem.equals("NOTHING") && tables.contains("Opt_" + nameOfItem))
			items = SQL.returnTableContents("Opt_" + nameOfItem, "Options");
		else
			items = new ArrayList<String>();

		panel.removeAll();
		ArrayList<MenuItemButton> itemButtons = new ArrayList<MenuItemButton>();
		for (int x = 0; x < items.size(); x++) {
			if (x < 8) {
				itemButtons.add(Commands.createOptionItemButton(items.get(x), 5 + (x * 100), 5));
			} else {
				itemButtons.add(Commands.createOptionItemButton(items.get(x), 5 + ((x - 8) * 100), 110));
			}	
			String nameOfOption = items.get(x);
			itemButtons.get(x).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Commands.addToTicket(Commands.ticketSpacing(nameOfOption, Double.parseDouble(SQL.returnPriceOfOption("Opt_" + nameOfItem, nameOfOption)), true),Double.parseDouble(SQL.returnPriceOfOption("Opt_" + nameOfItem, nameOfOption)));
				}
			});
			panel.add(itemButtons.get(x));
		}


		panel.add(Commands.buttonAdd);
		panel.add(Commands.buttonRemove);
		
	}

}
