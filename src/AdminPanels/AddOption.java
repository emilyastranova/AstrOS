package AdminPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;

import Commands.Commands;
import Main.Main;
import Vars.Vars;

public class AddOption extends JFrame {
	private static final long serialVersionUID = 1L;
	public static JPanel panel = new JPanel();
	
	public AddOption() {
		panel.setLayout(null);
		panel.setBackground(new Color(20,20,24));
		panel.setVisible(true);
		
		JLabel labelOptionName = new JLabel("Option Name: ");
		labelOptionName.setHorizontalAlignment(JLabel.CENTER);
		labelOptionName.setFont(Vars.fontDefault);
		labelOptionName.setBounds(0, 0, 400, 75);
		labelOptionName.setFont(Vars.fontGoogle);
		labelOptionName.setForeground(Color.white);
		panel.add(labelOptionName);
		
		JTextField textOptionName = new JTextField("Name");
		textOptionName.setHorizontalAlignment(JLabel.LEFT);
		textOptionName.setFont(Vars.fontDefault);
		textOptionName.setBounds(25, 60, 335, 45);
		textOptionName.setFont(Vars.fontGoogle);
		textOptionName.setForeground(Color.GRAY);
		textOptionName.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(textOptionName.getText().equals(""))
				textOptionName.setText("Name");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(textOptionName.getText().equals("Name"))
				textOptionName.setText("");
			}
		});
		panel.add(textOptionName);

		JLabel labelOptionPrice = new JLabel("Option Price: ");
		labelOptionPrice.setHorizontalAlignment(JLabel.CENTER);
		labelOptionPrice.setFont(Vars.fontDefault);
		labelOptionPrice.setBounds(0, 0, 400, 275);
		labelOptionPrice.setFont(Vars.fontGoogle);
		labelOptionPrice.setForeground(Color.white);
		panel.add(labelOptionPrice);
		
		JTextField textOptionPrice = new JTextField("Price");
		textOptionPrice.setHorizontalAlignment(JLabel.LEFT);
		textOptionPrice.setFont(Vars.fontDefault);
		textOptionPrice.setBounds(25, 160, 335, 45);
		textOptionPrice.setFont(Vars.fontGoogle);
		textOptionPrice.setForeground(Color.GRAY);
		textOptionPrice.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(textOptionPrice.getText().equals(""))
				textOptionPrice.setText("Price");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(textOptionPrice.getText().equals("Price"))
				textOptionPrice.setText("");
			}
		});
		panel.add(textOptionPrice);
		
		AdminButton buttonSubmit = new AdminButton();
		buttonSubmit.setText("SUBMIT");
		buttonSubmit.setFont(Commands.changeFontSize(20, Vars.fontGoogle));
		buttonSubmit.setBorder(null);
		buttonSubmit.setBounds(135, 225, 100, 60);
		panel.add(buttonSubmit);
		
		add(panel);
		setSize(new Dimension(400,450));
		Main.centerWindow(this);
		setTitle("Add Login");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String args[]) {
		new AddOption();
	}	
}