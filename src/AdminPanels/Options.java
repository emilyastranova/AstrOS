package AdminPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Vars.LocalSQL;
import Vars.Vars;

public class Options extends JPanel{
	
	public Options() {
		setLayout(null);
		setBackground(Color.WHITE);
		setSize(new Dimension(Vars.dimensionFullScreen.width / 3, 100));
		
		JLabel label = new JLabel("TEST");
		label.setBounds(50, 50, 200, 50);
		add(label);
	}
	

}
