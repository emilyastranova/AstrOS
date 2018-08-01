package HomePanels;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Commands.Commands;
import HomePanels.OptionsPanels.Breadsticks;
import Main.CustomColorButton;
import Vars.MenuVars;
import Vars.Vars;

public class Appetizers {
	public static JPanel panel = new JPanel();

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Vars.colorMainBG);

		JLabel label = new JLabel("Appetizers");
		label.setBounds(5, 20, 200, 80);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(Vars.fontDefault);
		panel.add(label);

		CustomColorButton buttonItem1 = Commands.createMenuItemButton("Breadsticks", 5, 100);
		buttonItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options.switchPanel(Breadsticks.panel);
				Commands.add2Ticket(MenuVars.strBreadsticks);
			}
		});
		
		ArrayList<CustomColorButton> buttonArray = new ArrayList<CustomColorButton>();
		
		
		panel.add(buttonItem1);
		CustomColorButton buttonItem2 = Commands.createMenuItemButton("Mozarella Sticks", 215, 100);
		panel.add(buttonItem2);
		CustomColorButton buttonItem3 = Commands.createMenuItemButton("Nachos", 425, 100);
		panel.add(buttonItem3);
		CustomColorButton buttonItem4 = Commands.createMenuItemButton("Wings", 635, 100);
		panel.add(buttonItem4);
		CustomColorButton buttonItem5 = Commands.createMenuItemButton("Jalapeno Poppers", 5, 210);
		panel.add(buttonItem5);
		CustomColorButton buttonItem6 = Commands.createMenuItemButton("Fried Pickles", 215, 210);
		panel.add(buttonItem6);

		panel.setBounds(0, 80, (Vars.dimensionFullScreen.width * 2 / 3), Vars.dimensionFullScreen.height);
	}
}
