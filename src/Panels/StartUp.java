package Panels;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Vars.Vars;
import Commands.Commands;
import Commands.SQL;
import Main.Main;

public class StartUp {
	public static JPanel panel = new JPanel();
	public static String SignInCode = "";

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Vars.colorMainBG);

		JButton buttonNormalStartup = Commands.createButton("<html>Click Here to Boot Normally</html>",
				Vars.halfScreenWidth - 175, Vars.halfScreenHeight, 300, 80, true);
		buttonNormalStartup.setFont(new Font(Vars.fontDefault.getFontName(), Font.PLAIN, 20));
		buttonNormalStartup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Commands.switchPanels(Main.panelStartUp, Main.panelSignIn);
			}
		});
		panel.add(buttonNormalStartup);
		JButton buttonAdminStartup = Commands.createButton("<html>Click Here to Boot into<br>Administrator Mode</html>",
				Vars.halfScreenWidth + 175, Vars.halfScreenHeight, 300, 80, true);
		buttonAdminStartup.setFont(new Font(Vars.fontDefault.getFontName(), Font.PLAIN, 20));
		buttonAdminStartup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Commands.switchPanels(Main.panelStartUp, Main.panelAdminLogin);
			}
		});
		panel.add(buttonAdminStartup);
	}
}