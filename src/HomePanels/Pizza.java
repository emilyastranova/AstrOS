package HomePanels;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Commands.Commands;
import HomePanels.OptionsPanels.OptionPanel;
import Main.MenuItemButton;
import Vars.LocalSQL;
import Vars.Vars;

public class Pizza {
	public static JPanel panel = new JPanel();
	public static ArrayList<ArrayList<String>> pizza;
	public static ArrayList<MenuItemButton> pizzaButtons = new ArrayList<MenuItemButton>();

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Vars.colorMainBG);

		pizza = LocalSQL.Pizza;
		
		JLabel label = new JLabel("Pizza");
		label.setBounds(5, 20, 200, 80);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(Vars.fontDefault);
		panel.add(label);

		setPizzaFromSQL();

		panel.setBounds(0, 80, (Vars.dimensionFullScreen.width * 2 / 3), Vars.dimensionFullScreen.height);
	}
	
	public static void setPizzaFromSQL() {
		for (int i = 0; i < pizza.size(); i++) {
			if (i < 4) {
				pizzaButtons.add(Commands.createMenuItemButton(pizza.get(i).get(0), ((i * 210) + 5), 100,Double.parseDouble(pizza.get(i).get(1))));
			} else if (i < 8) {				
				pizzaButtons.add(Commands.createMenuItemButton(pizza.get(i).get(0), (((i - 4) * 210) + 5), 210,Double.parseDouble(pizza.get(i).get(1))));
			} else {
				pizzaButtons.add(Commands.createMenuItemButton(pizza.get(i).get(0), (((i - 8) * 210) + 5), 320,Double.parseDouble(pizza.get(i).get(1))));
			}
		}

		for (int i = 0; i < pizzaButtons.size(); i++) {
			String nameOfItem = pizzaButtons.get(i).getName();
			double priceOfItem = pizzaButtons.get(i).getPrice();
			pizzaButtons.get(i).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					 Options.assignPanel(nameOfItem);
					 Commands.addToTicket(Commands.ticketSpacing(nameOfItem, priceOfItem),priceOfItem);
					 OptionPanel.updatePanel();
				}});
			panel.add(pizzaButtons.get(i));
		}
	}
}
