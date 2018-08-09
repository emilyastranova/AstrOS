package Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

import AdminPanels.AddLogin;
import AdminPanels.AddMenuItem;
import AdminPanels.AddOption;
import AdminPanels.AdminButton;
import AdminPanels.Login;
import AdminPanels.MenuItems;
import AdminPanels.Options;
import Commands.Commands;
import Main.Main;
import Vars.Vars;

public class AdminSettings {

	public static JPanel panel = new JPanel();
	public static Login panelLogin;
	public static MenuItems panelMenuItems;
	public static Options panelOptions;
	public static AddLogin frameAddLogin;
	public static AddMenuItem frameAddMenuItem;
	public static AddOption frameAddOption;

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(new Color(20,20,24));
		
		JButton button = new JButton(new ImageIcon("Resources/arrow.png"));
		button.setBounds(5, 5, 80, 80);
		button.setBorder(null);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Commands.switchPanels(Main.panelAdminSettings, Main.panelStartUp);
			}
		});
		panel.add(button);
		
		JLabel labelLogin = new JLabel("Login");
		labelLogin.setFont(Vars.fontDefault);
		labelLogin.setForeground(Color.WHITE);
		labelLogin.setHorizontalAlignment(JLabel.CENTER);
		labelLogin.setBounds(Vars.dimensionFullScreen.width /6 - 100, 10, 200, 100);
		labelLogin.setFont(new Font("Roboto",Font.PLAIN, 35));
		panel.add(labelLogin);
		
		JLabel labelMenuItems = new JLabel("Menu Items");
		labelMenuItems.setFont(Vars.fontDefault);
		labelMenuItems.setForeground(Color.WHITE);
		labelMenuItems.setHorizontalAlignment(JLabel.CENTER);
		labelMenuItems.setBounds(Vars.dimensionFullScreen.width /2 - 100, 10, 200, 100);
		labelMenuItems.setFont(new Font("Roboto",Font.PLAIN, 35));
		panel.add(labelMenuItems);
		
		JLabel labelOptions = new JLabel("Options");
		labelOptions.setFont(Vars.fontDefault);
		labelOptions.setForeground(Color.white);
		labelOptions.setHorizontalAlignment(JLabel.CENTER);
		labelOptions.setBounds(Vars.dimensionFullScreen.width * 5/6 - 100, 10, 200, 100);
		labelOptions.setFont(new Font("Roboto",Font.PLAIN, 35));
		panel.add(labelOptions);
		
		panelLogin = new Login();
		panelMenuItems = new MenuItems();
		panelOptions = new Options();
		frameAddLogin = new AddLogin();
		frameAddLogin.setVisible(false);
		frameAddMenuItem = new AddMenuItem();
		frameAddMenuItem.setVisible(false);
		frameAddOption = new AddOption();
		frameAddOption.setVisible(false);
		
		
		JScrollPane scrollLogin = new JScrollPane(panelLogin);
		scrollLogin.setBorder(null);
		scrollLogin.setBounds(0, 100, Vars.dimensionFullScreen.width / 3, Vars.dimensionFullScreen.height - 200);
		scrollLogin.getVerticalScrollBar().setUnitIncrement(16);
		scrollLogin.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollLogin.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollLogin);

		JScrollPane scrollMenuItems = new JScrollPane(panelMenuItems);
		scrollMenuItems.setBorder(null);
		scrollMenuItems.setBounds(Vars.dimensionFullScreen.width / 3, 100, Vars.dimensionFullScreen.width / 3, Vars.dimensionFullScreen.height - 200);
		scrollMenuItems.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollMenuItems.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollMenuItems.getVerticalScrollBar().setUnitIncrement(16);
		panel.add(scrollMenuItems);		
		
		JScrollPane scrollOptions = new JScrollPane(panelOptions);
		scrollOptions.setBorder(null);
		scrollOptions.setBounds(Vars.dimensionFullScreen.width * 2/3, 100, Vars.dimensionFullScreen.width / 3, Vars.dimensionFullScreen.height - 200);
		scrollOptions.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollOptions.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollOptions.getVerticalScrollBar().setUnitIncrement(16);
		panel.add(scrollOptions);
		
		AdminButton buttonLoginRemove = new AdminButton();
		buttonLoginRemove.setText("REMOVE");
		buttonLoginRemove.setFont(Commands.changeFontSize(20, Vars.fontGoogle));
		buttonLoginRemove.setBorder(null);
		buttonLoginRemove.setBounds(20, Vars.dimensionFullScreen.height - 95, 100, 60);
		buttonLoginRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanels.Loading temp = new AdminPanels.Loading();
				Timer tempTime =  new Timer(100, new ActionListener() {
		                public void actionPerformed(ActionEvent evt) {
		                	Login.removeLogins();
		                	panelLogin.refresh();
		                	temp.dispose();
		                }
		            });
				tempTime.start();
				tempTime.setRepeats(false);
			}
		});
		panel.add(buttonLoginRemove);
		
		AdminButton buttonLoginAdd = new AdminButton();
		buttonLoginAdd.setText("ADD");
		buttonLoginAdd.setFont(Commands.changeFontSize(20, Vars.fontGoogle));
		buttonLoginAdd.setBorder(null);
		buttonLoginAdd.setBounds(150, Vars.dimensionFullScreen.height - 95, 100, 60);
		buttonLoginAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameAddLogin.setVisible(true);
			}
		});
		panel.add(buttonLoginAdd);
		
		AdminButton buttonLoginRefresh = new AdminButton();
		buttonLoginRefresh.setText("REFRESH");
		buttonLoginRefresh.setFont(Commands.changeFontSize(20, Vars.fontGoogle));
		buttonLoginRefresh.setBorder(null);
		buttonLoginRefresh.setBounds(280, Vars.dimensionFullScreen.height - 95, 100, 60);
		buttonLoginRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanels.Loading temp = new AdminPanels.Loading();
				Timer tempTime =  new Timer(100, new ActionListener() {
		                public void actionPerformed(ActionEvent evt) {
		                	panelLogin.refresh();
		                	temp.dispose();
		                }
		            });
				tempTime.start();
				tempTime.setRepeats(false);
			}
		});
		panel.add(buttonLoginRefresh);
		
		AdminButton buttonMenuItemsRemove = new AdminButton();
		buttonMenuItemsRemove.setText("REMOVE");
		buttonMenuItemsRemove.setFont(Commands.changeFontSize(20, Vars.fontGoogle));
		buttonMenuItemsRemove.setBorder(null);
		buttonMenuItemsRemove.setBounds(440, Vars.dimensionFullScreen.height - 95, 100, 60);
		buttonMenuItemsRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanels.Loading temp = new AdminPanels.Loading();
				Timer tempTime =  new Timer(100, new ActionListener() {
		                public void actionPerformed(ActionEvent evt) {
		                	MenuItems.removeMenuItems();
		                	panelMenuItems.refresh();
		                	temp.dispose();
		                }
		            });
				tempTime.start();
				tempTime.setRepeats(false);
			}
		});
		panel.add(buttonMenuItemsRemove);
		
		AdminButton buttonMenuItemsAdd = new AdminButton();
		buttonMenuItemsAdd.setText("ADD");
		buttonMenuItemsAdd.setFont(Commands.changeFontSize(20, Vars.fontGoogle));
		buttonMenuItemsAdd.setBorder(null);
		buttonMenuItemsAdd.setBounds(570, Vars.dimensionFullScreen.height - 95, 100, 60);
		buttonMenuItemsAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameAddMenuItem.setVisible(true);
			}
		});
		panel.add(buttonMenuItemsAdd);
		
		AdminButton buttonMenuItemsRefresh = new AdminButton();
		buttonMenuItemsRefresh.setText("REFRESH");
		buttonMenuItemsRefresh.setFont(Commands.changeFontSize(20, Vars.fontGoogle));
		buttonMenuItemsRefresh.setBorder(null);
		buttonMenuItemsRefresh.setBounds(700, Vars.dimensionFullScreen.height - 95, 100, 60);
		buttonMenuItemsRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanels.Loading temp = new AdminPanels.Loading();
				Timer tempTime =  new Timer(100, new ActionListener() {
		                public void actionPerformed(ActionEvent evt) {
		                	panelMenuItems.refresh();
		                	temp.dispose();
		                }
		            });
				tempTime.start();
				tempTime.setRepeats(false);
			}
		});
		panel.add(buttonMenuItemsRefresh);
		
		AdminButton buttonOptionsRemove = new AdminButton();
		buttonOptionsRemove.setText("REMOVE");
		buttonOptionsRemove.setFont(Commands.changeFontSize(20, Vars.fontGoogle));
		buttonOptionsRemove.setBorder(null);
		buttonOptionsRemove.setBounds(870, Vars.dimensionFullScreen.height - 95, 100, 60);
		buttonOptionsRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanels.Loading temp = new AdminPanels.Loading();
				Timer tempTime =  new Timer(100, new ActionListener() {
		                public void actionPerformed(ActionEvent evt) {
		                	Options.removeOptions();
		                	panelOptions.refresh();
		                	temp.dispose();
		                }
		            });
				tempTime.start();
				tempTime.setRepeats(false);
			}
		});
		panel.add(buttonOptionsRemove);
		
		AdminButton buttonOptionsAdd = new AdminButton();
		buttonOptionsAdd.setText("ADD");
		buttonOptionsAdd.setFont(Commands.changeFontSize(20, Vars.fontGoogle));
		buttonOptionsAdd.setBorder(null);
		buttonOptionsAdd.setBounds(570, Vars.dimensionFullScreen.height - 95, 100, 60);
		buttonOptionsAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameAddOption.setVisible(true);
			}
		});
		panel.add(buttonOptionsAdd);
		
		AdminButton buttonOptionsRefresh = new AdminButton();
		buttonOptionsRefresh.setText("REFRESH");
		buttonOptionsRefresh.setFont(Commands.changeFontSize(20, Vars.fontGoogle));
		buttonOptionsRefresh.setBorder(null);
		buttonOptionsRefresh.setBounds(700, Vars.dimensionFullScreen.height - 95, 100, 60);
		buttonOptionsRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanels.Loading temp = new AdminPanels.Loading();
				Timer tempTime =  new Timer(100, new ActionListener() {
		                public void actionPerformed(ActionEvent evt) {
		                	panelOptions.refresh();
		                	temp.dispose();
		                }
		            });
				tempTime.start();
				tempTime.setRepeats(false);
			}
		});
		panel.add(buttonOptionsRefresh);
	}
}
