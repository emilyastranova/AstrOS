package HomePanels.OptionsPanels;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import Commands.Commands;
import Commands.SQL;
import HomePanels.Appetizers;
import Main.MenuItem;
import Vars.Vars;

public class OptionPanel {

	public static JPanel panel = new JPanel();
	public static String nameOfItem = "NOTHING";
	public static ArrayList<String> items;
	public static ArrayList<String> availableOptions;

	public static void setNameOfItem(String n) {
		nameOfItem = n;
	}

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(null);
		panel.setBounds(5, 5, (Vars.dimensionFullScreen.width * 2 / 3) - 5, Vars.dimensionFullScreen.height / 3 - 5);
	}
	
	public static void updatePanel() {
		System.out.println(nameOfItem);
		availableOptions = SQL.returnAllContents();
		System.out.println(availableOptions);
		
		
		for (int x = 0; x < Appetizers.getItems().size(); x++) {
			if (!nameOfItem.equals("NOTHING")&&availableOptions.contains("Opt_" + nameOfItem))
				items = SQL.returnTableContents("Opt_" + nameOfItem, "Options");
		}

		if (nameOfItem.equals("Breadsticks")) {
			MenuItem buttonOption1 = Commands.createOptionItemButton("Marinara Sauce", 5, 5);
			panel.add(buttonOption1);
			MenuItem buttonOption2 = Commands.createOptionItemButton("Alfredo Sauce", 160, 5);
			panel.add(buttonOption2);
			MenuItem buttonOption3 = Commands.createOptionItemButton("No Sauce", 315, 5);
			panel.add(buttonOption3);
		}
	}

}
