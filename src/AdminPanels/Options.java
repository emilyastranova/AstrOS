package AdminPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import AdminPanels.AdminOptionButton;
import Commands.Commands;
import Panels.AdminSettings;
import Vars.LocalSQL;
import Vars.Vars;

public class Options extends JPanel {
	
	public static ArrayList<ArrayList<String>> optionsTemp;
	public static ArrayList<AdminOptionButton> buttons;
	
	public Options() {
		setLayout(null);
		setBackground(Color.WHITE);
		setSize(new Dimension(Vars.dimensionFullScreen.width / 3, 100));
		
		buttons = new ArrayList<AdminOptionButton>();
	}
	
	public void refresh() {
		LocalSQL.refresh();
		removeAll();
		buttons = new ArrayList<AdminOptionButton>();
		for (int i = 0; i < optionsTemp.size(); i++) {
			buttons.add(new AdminOptionButton(i));
			buttons.get(i).setText(optionsTemp.get(i).get(0));
			buttons.get(i).setName(optionsTemp.get(i).get(0));
			buttons.get(i).setSize(300, 50);
			buttons.get(i).setLocation(50, (60*i)+10);
			buttons.get(i).setBorder(null);
			buttons.get(i).setFont(Commands.changeFontSize(20, Vars.fontGoogle));
			buttons.get(i).setPrice(optionsTemp.get(i).get(1));
			add(buttons.get(i));
		}
		setVisible(false);
		setVisible(true);
	}

	public static void switchPanels(String name) {
		optionsTemp = LocalSQL.returnOptionsByName(name);
		System.out.println(optionsTemp);
		AdminSettings.panelOptions.refresh();
	}
	
	public static void removeOptions() {
		
	}

}
