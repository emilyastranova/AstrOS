package HomePanels;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Commands.Commands;
import Commands.SQL;
import HomePanels.OptionsPanels.OptionPanel;
import Main.MenuItem;
import Vars.Vars;

public class Appetizers {
	public static JPanel panel = new JPanel();
	public static ArrayList<String> appetizers = SQL.returnTableContents("Appetizers", "Menu Items");
	public static ArrayList<MenuItem> appetizerButtons = new ArrayList<MenuItem>();

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Vars.colorMainBG);

		JLabel label = new JLabel("Appetizers");
		label.setBounds(5, 20, 200, 80);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(Vars.fontDefault);
		panel.add(label);

		setAppetizersFromSQL();

		/*
		 * CustomColorButton buttonItem1 = Commands.createMenuItemButton("Breadsticks",
		 * 5, 100); buttonItem1.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { Options.switchPanel(Breadsticks.panel);
		 * Commands.add2Ticket(MenuVars.strBreadsticks); } }); panel.add(buttonItem1);
		 * CustomColorButton buttonItem2 =
		 * Commands.createMenuItemButton("Mozarella Sticks", 215, 100);
		 * panel.add(buttonItem2); CustomColorButton buttonItem3 =
		 * Commands.createMenuItemButton("Nachos", 425, 100); panel.add(buttonItem3);
		 * CustomColorButton buttonItem4 = Commands.createMenuItemButton("Wings", 635,
		 * 100); panel.add(buttonItem4); CustomColorButton buttonItem5 =
		 * Commands.createMenuItemButton("Fried Jalapenos", 5, 210);
		 * panel.add(buttonItem5); CustomColorButton buttonItem6 =
		 * Commands.createMenuItemButton("Fried Pickles", 215, 210);
		 * panel.add(buttonItem6);
		 */

		panel.setBounds(0, 80, (Vars.dimensionFullScreen.width * 2 / 3), Vars.dimensionFullScreen.height);
	}
	
	public static void setAppetizersFromSQL() {
		for (int i = 0; i < appetizers.size(); i++) {
			if (i < 4) {
				appetizerButtons.add(Commands.createMenuItemButton(appetizers.get(i), ((i * 210) + 5), 100));
			} else {
				appetizerButtons.add(Commands.createMenuItemButton(appetizers.get(i), (((i - 4) * 210) + 5), 210));
			}
		}

		for (int i = 0; i < appetizerButtons.size(); i++) {
			String nameOfItem = appetizerButtons.get(i).getName();
			appetizerButtons.get(i).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					 Options.assignPanel(nameOfItem);
					 OptionPanel.updatePanel();
				}});
			panel.add(appetizerButtons.get(i));
		}
	}
	
	public static ArrayList<MenuItem> getItems(){
		return appetizerButtons;
	}
}
