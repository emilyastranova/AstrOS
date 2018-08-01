package Panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Commands.Commands;
import Commands.SQL;
import Main.Main;
import Vars.Vars;

public class SignIn {
	public static JPanel panel = new JPanel();
	public static String tempSignInCode = "";
	public static String SignInCode = "";
	
	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Vars.colorMainBG);
		
		JLabel labelIncorrectCode = new JLabel("Incorrect ID Number");
		labelIncorrectCode.setHorizontalAlignment(JLabel.CENTER);
		labelIncorrectCode.setFont(Commands.changeFontSize(20));
		labelIncorrectCode.setForeground(new Color(250, 0, 0));
		labelIncorrectCode.setBounds(Vars.halfScreenWidth - 100, Vars.halfScreenHeight - 375, 200, 80);
		
		JTextField textFieldSignInCode = new JTextField();
		textFieldSignInCode.setFont(Vars.fontDefault);
		textFieldSignInCode.setHorizontalAlignment(JTextField.CENTER);
		textFieldSignInCode.setBounds(Vars.halfScreenWidth - 100, Vars.halfScreenHeight - 300, 200, 80);
		panel.add(textFieldSignInCode);
		
		JButton buttonNum1 = Commands.createButton("1", Vars.halfScreenWidth - 125, Vars.halfScreenHeight - 150, 100, 100, true);	
		buttonNum1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempSignInCode += "1";
				textFieldSignInCode.setText(tempSignInCode);
			}
		});
		panel.add(buttonNum1);
		JButton buttonNum2 = Commands.createButton("2", Vars.halfScreenWidth, Vars.halfScreenHeight - 150, 100, 100, true);	
		buttonNum2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempSignInCode += "2";
				textFieldSignInCode.setText(tempSignInCode);
			}
		});
		panel.add(buttonNum2);
		JButton buttonNum3 = Commands.createButton("3", Vars.halfScreenWidth + 125, Vars.halfScreenHeight - 150, 100, 100, true);	
		buttonNum3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempSignInCode += "3";
				textFieldSignInCode.setText(tempSignInCode);
			}
		});
		panel.add(buttonNum3);
		JButton buttonNum4 = Commands.createButton("4", Vars.halfScreenWidth - 125, Vars.halfScreenHeight - 25, 100, 100, true);	
		buttonNum4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempSignInCode += "4";
				textFieldSignInCode.setText(tempSignInCode);
			}
		});
		panel.add(buttonNum4);
		JButton buttonNum5 = Commands.createButton("5", Vars.halfScreenWidth, Vars.halfScreenHeight - 25, 100, 100, true);	
		buttonNum5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempSignInCode += "5";
				textFieldSignInCode.setText(tempSignInCode);
			}
		});
		panel.add(buttonNum5);
		JButton buttonNum6 = Commands.createButton("6", Vars.halfScreenWidth + 125, Vars.halfScreenHeight - 25, 100, 100, true);	
		buttonNum6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempSignInCode += "6";
				textFieldSignInCode.setText(tempSignInCode);
			}
		});
		panel.add(buttonNum6);
		JButton buttonNum7 = Commands.createButton("7", Vars.halfScreenWidth - 125, Vars.halfScreenHeight + 100, 100, 100, true);	
		buttonNum7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempSignInCode += "7";
				textFieldSignInCode.setText(tempSignInCode);
			}
		});
		panel.add(buttonNum7);
		JButton buttonNum8 = Commands.createButton("8", Vars.halfScreenWidth, Vars.halfScreenHeight + 100, 100, 100, true);	
		buttonNum8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempSignInCode += "8";
				textFieldSignInCode.setText(tempSignInCode);
			}
		});
		panel.add(buttonNum8);
		JButton buttonNum9 = Commands.createButton("9", Vars.halfScreenWidth + 125, Vars.halfScreenHeight + 100, 100, 100, true);	
		buttonNum9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempSignInCode += "9";
				textFieldSignInCode.setText(tempSignInCode);
			}
		});
		panel.add(buttonNum9);
		JButton buttonNumBack = Commands.createButton("<", Vars.halfScreenWidth - 125, Vars.halfScreenHeight + 225, 100, 100, true);	
		buttonNumBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempSignInCode = Commands.removeLastChar(tempSignInCode);
				textFieldSignInCode.setText(tempSignInCode);
			}
		});
		panel.add(buttonNumBack);
		JButton buttonNum0 = Commands.createButton("0", Vars.halfScreenWidth, Vars.halfScreenHeight + 225, 100, 100, true);	
		buttonNum0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempSignInCode += "0";
				textFieldSignInCode.setText(tempSignInCode);
			}
		});
		panel.add(buttonNum0);
		JButton buttonNumGo = Commands.createButton(">", Vars.halfScreenWidth + 125, Vars.halfScreenHeight + 225, 100, 100, true);	
		buttonNumGo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignInCode = tempSignInCode;
				if (SQL.checkSignInCode(SignInCode)) {
					System.out.println("Logged in using ID#: " + SQL.currentID + " - " + SQL.currentName);
					Commands.switchPanels(Main.panelSignIn, Main.panelHome);
				} else {
					panel.add(labelIncorrectCode);
					Main.MainFrame.getContentPane().setVisible(false);
					Main.MainFrame.getContentPane().setVisible(true);					
				}
			}
		});
		panel.add(buttonNumGo);
		
	}	
}
