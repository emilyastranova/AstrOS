package AdminPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;

import Commands.Commands;
import Commands.SQL;
import Main.Main;
import Panels.AdminSettings;
import Vars.Vars;

public class AddLogin extends JFrame {
	private static final long serialVersionUID = 1L;
	public static JPanel panel = new JPanel();

	public AddLogin() {
		panel.setLayout(null);
		panel.setBackground(new Color(20, 20, 24));

		JLabel labelUsername = new JLabel("Username: ");
		labelUsername.setHorizontalAlignment(JLabel.CENTER);
		labelUsername.setFont(Vars.fontDefault);
		labelUsername.setBounds(0, 0, 400, 75);
		labelUsername.setFont(Vars.fontGoogle);
		labelUsername.setForeground(Color.white);

		JTextField username = new JTextField("Username");
		username.setHorizontalAlignment(JLabel.LEFT);
		username.setFont(Vars.fontDefault);
		username.setBounds(25, 60, 335, 45);
		username.setFont(Vars.fontGoogle);
		username.setForeground(Color.GRAY);
		username.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (username.getText().equals(""))
					username.setText("Username");
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (username.getText().equals("Username"))
					username.setText("");
			}
		});

		JLabel labelPassword = new JLabel("Password: ");
		labelPassword.setHorizontalAlignment(JLabel.CENTER);
		labelPassword.setFont(Vars.fontDefault);
		labelPassword.setBounds(0, 0, 400, 275);
		labelPassword.setFont(Vars.fontGoogle);
		labelPassword.setForeground(Color.white);

		JPasswordField password = new JPasswordField("");
		password.setHorizontalAlignment(JLabel.LEFT);
		password.setBounds(25, 160, 335, 45);
		password.setFont(Vars.fontDefault);
		password.setForeground(Color.GRAY);
		password.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (password.getText().equals(""))
					password.setText("");
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (password.getText().equals(""))
					password.setText("");
			}
		});

		JLabel labelConfirmPassword = new JLabel("Confirm Password: ");
		labelConfirmPassword.setHorizontalAlignment(JLabel.CENTER);
		labelConfirmPassword.setBounds(0, 0, 400, 475);
		labelConfirmPassword.setFont(Vars.fontGoogle);
		labelConfirmPassword.setForeground(Color.white);

		JPasswordField confirmPassword = new JPasswordField("");
		confirmPassword.setHorizontalAlignment(JLabel.LEFT);
		confirmPassword.setBounds(25, 260, 335, 45);
		confirmPassword.setFont(Vars.fontDefault);
		confirmPassword.setForeground(Color.GRAY);
		confirmPassword.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (confirmPassword.getText().equals(""))
					confirmPassword.setText("");
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (confirmPassword.getText().equals(""))
					confirmPassword.setText("");
			}
		});

		JLabel labelDontMatch = new JLabel("The passwords do not match");
		labelDontMatch.setFont(Vars.fontGoogle);
		labelDontMatch.setHorizontalAlignment(JLabel.CENTER);
		labelDontMatch.setBounds(0, 325, 400, 50);
		labelDontMatch.setForeground(Color.RED);
		
		AdminButton buttonSubmit = new AdminButton();
		buttonSubmit.setText("SUBMIT");
		buttonSubmit.setFont(Commands.changeFontSize(20, Vars.fontGoogle));
		buttonSubmit.setBorder(null);
		buttonSubmit.setBounds(135, 325, 100, 60);
		buttonSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (password.getText().equals(confirmPassword.getText())) {
					panel.remove(labelDontMatch);
					AdminPanels.Loading temp = new AdminPanels.Loading();
					Timer tempTime = new Timer(100, new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							ArrayList<String> columns = new ArrayList<String>();
							ArrayList<String> values = new ArrayList<String>();
							columns.add("Name");
							columns.add("ID");
							values.add(username.getText());
							values.add(password.getText());
							SQL.initConnect();
							SQL.addRow("Login", columns, values);
							SQL.closeConnection();
							AdminSettings.panelLogin.refresh();
							temp.dispose();
						}
					});
					tempTime.start();
					tempTime.setRepeats(false);
					AdminSettings.frameAddLogin.setVisible(false);
				} else {
					panel.add(labelDontMatch);
				}
			}
		});

		panel.add(buttonSubmit);
		panel.add(username);
		panel.add(password);
		panel.add(confirmPassword);
		panel.add(labelUsername);
		panel.add(labelPassword);
		panel.add(labelConfirmPassword);
		panel.setVisible(true);

		add(panel);
		setSize(new Dimension(400, 450));
		Main.centerWindow(this);
		setTitle("Add Login");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String args[]) {
		new AddLogin();
	}

}

/*
 * AdminPanels.Loading temp = new AdminPanels.Loading(); Timer tempTime = new
 * Timer(100, new ActionListener() { public void actionPerformed(ActionEvent
 * evt) { panelLogin.refresh(); temp.dispose(); } }); tempTime.start();
 * tempTime.setRepeats(false);
 */
