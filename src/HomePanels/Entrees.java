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
import Main.MenuItemButton;
import Vars.Vars;

public class Entrees {
	public static JPanel panel = new JPanel();
	public static ArrayList<String> entrees = SQL.returnTableContents("Entrees", "Items");
	public static ArrayList<MenuItemButton> entreeButtons = new ArrayList<MenuItemButton>();

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Vars.colorMainBG);

		JLabel label = new JLabel("Entrees");
		label.setBounds(5, 20, 200, 80);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(Vars.fontDefault);
		panel.add(label);
		
		setEntreesFromSQL();

		panel.setBounds(0, 80, (Vars.dimensionFullScreen.width * 2 / 3), Vars.dimensionFullScreen.height);
	}

	public static void setEntreesFromSQL() {
		for (int i = 0; i < entrees.size(); i++) {
			if (i < 4) {
				entreeButtons.add(Commands.createMenuItemButton(entrees.get(i), ((i * 210) + 5), 100));
			} else {
				entreeButtons.add(Commands.createMenuItemButton(entrees.get(i), (((i - 4) * 210) + 5), 210));
			}
		}

		for (int i = 0; i < entreeButtons.size(); i++) {
			String nameOfItem = entreeButtons.get(i).getName();
			entreeButtons.get(i).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					 Options.assignPanel(nameOfItem);
					 Commands.add2Ticket(Commands.ticketSpacing(nameOfItem, Double.parseDouble(SQL.returnPriceOfItem("Entrees", nameOfItem))),Double.parseDouble(SQL.returnPriceOfItem("Entrees", nameOfItem)));
					 OptionPanel.updatePanel();
				}});
			panel.add(entreeButtons.get(i));
		}		
	}
}
