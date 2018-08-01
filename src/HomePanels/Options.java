package HomePanels;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import HomePanels.OptionsPanels.Blank;
import HomePanels.OptionsPanels.Breadsticks;
import Vars.Vars;

public class Options {
	public static JPanel panel = new JPanel();

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(new Color(200, 200, 200));
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		Breadsticks.createView(g);
		Blank.createView(g);
		panel.add(Blank.panel);

		panel.setBounds(0, (Vars.dimensionFullScreen.height * 2 / 3), (Vars.dimensionFullScreen.width * 2 / 3),Vars.dimensionFullScreen.height / 3);
	}

	public static void switchPanel(JPanel panelNew) {
		panel.removeAll();
		panel.add(panelNew);
		panel.setVisible(false);
		panel.setVisible(true);
	}
}
