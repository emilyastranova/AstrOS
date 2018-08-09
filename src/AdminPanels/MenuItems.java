package AdminPanels;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Commands.Commands;
import Commands.SQL;
import Vars.LocalSQL;
import Vars.Vars;

public class MenuItems extends JPanel {
	
	private static final long serialVersionUID = 1L;
	public static ArrayList<AdminMenuItemButton> buttons;
	public static int NumOfItems;

	public MenuItems() {
		setLayout(null);
		setBackground(Color.white);
		setLocation(0, 100);
		setPreferredSize(new Dimension(Vars.dimensionFullScreen.width / 3, (LocalSQL.AllItems.size() * 60) + 40));
		
		buttons = new ArrayList<AdminMenuItemButton>();
		for (int i = 0; i < LocalSQL.AllItems.size(); i++) {
			buttons.add(new AdminMenuItemButton(i));
			buttons.get(i).setText(LocalSQL.AllItems.get(i).get(0));
			buttons.get(i).setName(LocalSQL.AllItems.get(i).get(0));
			buttons.get(i).setSize(300, 50);
			buttons.get(i).setLocation(50, (60*i)+10);
			buttons.get(i).setBorder(null);
			buttons.get(i).setFont(Commands.changeFontSize(20, Vars.fontGoogle));
			buttons.get(i).setPrice(LocalSQL.AllItems.get(i).get(1));
			if (i < LocalSQL.Appetizers.size()) {
				buttons.get(i).setCategory("Appetizers");
			} else if (i < LocalSQL.Appetizers.size() + LocalSQL.Entrees.size()) {
				buttons.get(i).setCategory("Entrees");
			} else if (i < LocalSQL.Appetizers.size() + LocalSQL.Entrees.size() + LocalSQL.Pizza.size()) {
				buttons.get(i).setCategory("Pizza");
			} else {
				buttons.get(i).setCategory("Subs");
			}
			add(buttons.get(i));
		}
		setVisible(false);
		setVisible(true);
	}
	
	public void refresh() {
		LocalSQL.refresh();
		removeAll();
		setPreferredSize(new Dimension(Vars.dimensionFullScreen.width / 3, (LocalSQL.AllItems.size() * 60) + 40));
		
		buttons = new ArrayList<AdminMenuItemButton>();
		for (int i = 0; i < LocalSQL.AllItems.size(); i++) {
			buttons.add(new AdminMenuItemButton(i));
			buttons.get(i).setText(LocalSQL.AllItems.get(i).get(0));
			buttons.get(i).setName(LocalSQL.AllItems.get(i).get(0));
			buttons.get(i).setSize(300, 50);
			buttons.get(i).setLocation(50, (60*i)+10);
			buttons.get(i).setBorder(null);
			buttons.get(i).setFont(Commands.changeFontSize(20, Vars.fontGoogle));
			buttons.get(i).setPrice(LocalSQL.AllItems.get(i).get(1));
			if (i < LocalSQL.Appetizers.size()) {
				buttons.get(i).setCategory("Appetizers");
			} else if (i < LocalSQL.Appetizers.size() + LocalSQL.Entrees.size()) {
				buttons.get(i).setCategory("Entrees");
			} else if (i < LocalSQL.Appetizers.size() + LocalSQL.Entrees.size() + LocalSQL.Pizza.size()) {
				buttons.get(i).setCategory("Pizza");
			} else {
				buttons.get(i).setCategory("Subs");
			}
			add(buttons.get(i));
		}
		setVisible(false);
		setVisible(true);
	}
	
	public static void removeMenuItems() {
		SQL.initConnect();
		for (int i = 0; i < buttons.size(); i++) {
			if (buttons.get(i).isSelected()) {
				SQL.removeRow(buttons.get(i).getCategory(), "Items", buttons.get(i).getName());
				SQL.dropTable("Opt_" + buttons.get(i).getName());
			}
		}
		SQL.closeConnection();
	}
	
	public static void unselectAll() {
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).setSelected(false);
			buttons.get(i).repaint();
		}
	}
	
	public static String getSelectedItem() {
		for (int i = 0; i < buttons.size(); i++) {
			if (buttons.get(i).isSelected()) {
				return buttons.get(i).getName();
			}
		}

		return null;
	}
}
