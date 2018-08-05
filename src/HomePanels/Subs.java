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

public class Subs {
	public static JPanel panel = new JPanel();
	public static ArrayList<String> subs = SQL.returnTableContents("Subs", "Items");
	public static ArrayList<MenuItemButton> subButtons = new ArrayList<MenuItemButton>();

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Vars.colorMainBG);

		JLabel label = new JLabel("Subs");
		label.setBounds(5, 20, 200, 80);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(Vars.fontDefault);
		panel.add(label);
		
		setSubsFromSQL();

		panel.setBounds(0, 80, (Vars.dimensionFullScreen.width * 2 / 3), Vars.dimensionFullScreen.height);
	}

	public static void setSubsFromSQL() {
		for (int i = 0; i < subs.size(); i++) {
			if (i < 4) {
				subButtons.add(Commands.createMenuItemButton(subs.get(i), ((i * 210) + 5), 100));
			} else {
				subButtons.add(Commands.createMenuItemButton(subs.get(i), (((i - 4) * 210) + 5), 210));
			}
		}

		for (int i = 0; i < subButtons.size(); i++) {
			String nameOfItem = subButtons.get(i).getName();
			subButtons.get(i).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					 Options.assignPanel(nameOfItem);
					 Commands.add2Ticket(Commands.ticketSpacing(nameOfItem, Double.parseDouble(SQL.returnPriceOfItem("Subs", nameOfItem))),Double.parseDouble(SQL.returnPriceOfItem("Subs", nameOfItem)));
					 OptionPanel.updatePanel();
				}});
			panel.add(subButtons.get(i));
		}		
	}
}
