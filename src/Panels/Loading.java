package Panels;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Vars.Vars;

public class Loading extends JFrame{
	public static JPanel panel = new JPanel();
	
	public Loading() {
		panel.setLayout(null);
		panel.setBackground(Vars.colorMainBG);

		JLabel labelLoading = new JLabel("Loading...");
		labelLoading.setHorizontalAlignment(JLabel.CENTER);
		labelLoading.setFont(Vars.fontDefault);
		labelLoading.setBounds(Vars.halfScreenWidth - 50, Vars.halfScreenHeight - 40, 100, 80);
		panel.add(labelLoading);
		add(panel);
		
		setVisible(true);
	}

	public static void main(String args[]) {
		Loading test = new Loading();
	}
	
}
