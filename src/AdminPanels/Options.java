package AdminPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import Commands.Commands;
import Vars.LocalSQL;
import Vars.Vars;

public class Options extends JPanel {
	
	public Options() {
		setLayout(null);
		setBackground(Color.WHITE);
		setSize(new Dimension(Vars.dimensionFullScreen.width / 3, 100));
		
		
		
	}
	
	public void refresh() {
		LocalSQL.refresh();
	}

	public static void switchPanels(String name) {
		
	}
	
	public static void removeOptions() {
		
	}

}
