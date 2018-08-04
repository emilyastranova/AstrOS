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

public class Pizza {
	public static JPanel panel = new JPanel();
	public static ArrayList<String> pizzas = SQL.returnTableContents("Pizza", "Items");
	public static ArrayList<MenuItem> pizzaButtons = new ArrayList<MenuItem>();

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Vars.colorMainBG);

		JLabel label = new JLabel("Pizza");
		label.setBounds(5, 20, 200, 80);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(Vars.fontDefault);
		panel.add(label);
		
		setPizzaFromSQL();

		panel.setBounds(0, 80, (Vars.dimensionFullScreen.width * 2 / 3), Vars.dimensionFullScreen.height);
	}

	public static void setPizzaFromSQL() {
		for (int i = 0; i < pizzas.size(); i++) {
			if (i < 4) {
				pizzaButtons.add(Commands.createMenuItemButton(pizzas.get(i), ((i * 210) + 5), 100));
			} else {
				pizzaButtons.add(Commands.createMenuItemButton(pizzas.get(i), (((i - 4) * 210) + 5), 210));
			}
		}

		for (int i = 0; i < pizzaButtons.size(); i++) {
			String nameOfItem = pizzaButtons.get(i).getName();
			pizzaButtons.get(i).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					 Options.assignPanel(nameOfItem);
					 Commands.add2Ticket(Commands.ticketSpacing(nameOfItem, Double.parseDouble(SQL.returnPriceOfItem("Pizza", nameOfItem))));
					 Ticket.prices.add(Double.parseDouble(SQL.returnPriceOfItem("Pizza", nameOfItem)));
					 OptionPanel.updatePanel();
				}});
			panel.add(pizzaButtons.get(i));
		}		
	}
}
