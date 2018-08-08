package AdminPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Main.Main;
import Vars.Vars;

public class AddLogin extends JFrame{
	public static JPanel panel = new JPanel();
	
	public AddLogin() {
		panel.setLayout(null);
		panel.setBackground(new Color(20,20,24));

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
				if(username.getText().equals(""))
				username.setText("Username");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(username.getText().equals("Username"))
				username.setText("");
			}
		});
		
		JLabel labelPassword = new JLabel("Password: ");
		labelPassword.setHorizontalAlignment(JLabel.CENTER);
		labelPassword.setFont(Vars.fontDefault);
		labelPassword.setBounds(0, 0, 400, 275);
		labelPassword.setFont(Vars.fontGoogle);
		labelPassword.setForeground(Color.white);
		
		JPasswordField password = new JPasswordField("Pass");
		password.setHorizontalAlignment(JLabel.LEFT);
		password.setFont(Vars.fontDefault);
		password.setBounds(25, 160, 335, 45);
		password.setFont(Vars.fontGoogle);
		password.setForeground(Color.GRAY);
		password.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(password.getText().equals(""))
				password.setText("Pass");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(password.getText().equals("Pass"))
				password.setText("");
			}
		});
		
		JLabel labelConfirmPassword = new JLabel("Confirm Password: ");
		labelConfirmPassword.setHorizontalAlignment(JLabel.CENTER);
		labelConfirmPassword.setFont(Vars.fontDefault);
		labelConfirmPassword.setBounds(0, 0, 400, 475);
		labelConfirmPassword.setFont(Vars.fontGoogle);
		labelConfirmPassword.setForeground(Color.white);
		
		JPasswordField confirmPassword = new JPasswordField("Pass");
		confirmPassword.setHorizontalAlignment(JLabel.LEFT);
		confirmPassword.setFont(Vars.fontDefault);
		confirmPassword.setBounds(25, 260, 335, 45);
		confirmPassword.setFont(Vars.fontGoogle);
		confirmPassword.setForeground(Color.GRAY);
		confirmPassword.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(confirmPassword.getText().equals(""))
				confirmPassword.setText("Pass");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(confirmPassword.getText().equals("Pass"))
				confirmPassword.setText("");
			}
		});
		
		panel.add(username);
		panel.add(password);
		panel.add(confirmPassword);
		panel.add(labelUsername);
		panel.add(labelPassword);
		panel.add(labelConfirmPassword);
		panel.setVisible(true);
		
		add(panel);
		setSize(new Dimension(400,450));
		Main.centerWindow(this);
		setTitle("Add Login");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String args[]) {
		new AddLogin();
	}
	
	
	
}

/*
AdminPanels.Loading temp = new AdminPanels.Loading();
				Timer tempTime =  new Timer(100, new ActionListener() {
		                public void actionPerformed(ActionEvent evt) {
		                	panelLogin.refresh();
		                	temp.dispose();
		                }
		            });
				tempTime.start();
				tempTime.setRepeats(false);
 */
