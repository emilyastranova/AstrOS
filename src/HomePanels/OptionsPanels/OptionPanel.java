package HomePanels.OptionsPanels;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import Commands.Commands;
import Commands.SQL;
import Main.MenuItem;
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
		ArrayList<MenuItem> itemButtons = new ArrayList<MenuItem>();
		for (int x = 0; x < items.size(); x++) {
			itemButtons.add(Commands.createOptionItemButton(items.get(x), 5 + (x * 155), 5));
			String nameOfOption = itemButtons.get(x).getName();
			itemButtons.get(x).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Commands.add2Ticket(Commands.ticketSpacing(nameOfOption, Double.parseDouble(SQL.returnPriceOfOption("Opt_" + nameOfItem, nameOfOption))));				}
			});
			panel.add(itemButtons.get(x));
		}
	}

}
