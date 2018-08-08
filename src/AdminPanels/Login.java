package AdminPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import Commands.SQL;
import Vars.LocalSQL;
import Vars.Vars;

public class Login extends JPanel {
	private static final long serialVersionUID = 1L;
	public static ArrayList<AdminLoginButton> buttons;

	public Login() {
		setLayout(null);
		setBackground(Color.WHITE);
		setLocation(0, 100);
		
		refresh();
	}
	
	public void refresh() {
		LocalSQL.refresh();
		removeAll();
		setPreferredSize(new Dimension(Vars.dimensionFullScreen.width / 3, (LocalSQL.Logins.size() * 75) + 40));
		
		buttons = new ArrayList<AdminLoginButton>();
		for (int i = 0; i < LocalSQL.Logins.size(); i++) {
			buttons.add(new AdminLoginButton(i));
			buttons.get(i).setText(LocalSQL.Logins.get(i).get(1));
			buttons.get(i).setSize(300, 50);
			buttons.get(i).setLocation(50, (75*i)+25);
			buttons.get(i).setBorder(null);
			buttons.get(i).setFont(Vars.fontGoogle);
			buttons.get(i).setID(LocalSQL.Logins.get(i).get(0));
			add(buttons.get(i));
		}
		setVisible(false);
		setVisible(true);
	}
	
	public static void removeLogins() {
		SQL.initConnect();
		for (int i = 0; i < buttons.size(); i++) {
			if (buttons.get(i).isSelected()) {
				SQL.removeRow("Login", "ID", buttons.get(i).getID());
			}
		}
		SQL.closeConnection();
	}
}
