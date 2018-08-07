package HomePanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Commands.Commands;
import Main.MenuItem;
import Main.MenuItemButton;
import Vars.Vars;

public class Ticket {
	public static JPanel panel = new JPanel();
	public static JPanel itemsPanel = new JPanel();
	public static String ticket;
	public static JTextField totalPrice;
	public static JScrollPane scrollPane;
	public static MenuItemButton buttonSeeMe;
	public static ArrayList<MenuItem> ticketItems = new ArrayList<MenuItem>();
	public static int buttonSize = 50;
	public static DecimalFormat formatter = new DecimalFormat("#,##0.00");

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(new Color(200, 200, 200));
		panel.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.BLACK));
		
		buttonSeeMe = new MenuItemButton(Vars.colorDefaultButton, Vars.colorDefaultFont);
		buttonSeeMe.setText("SEE ME");
		buttonSeeMe.setFont(Commands.changeFontSize(15));
		buttonSeeMe.setBounds(155, 630, 100, 50);
		buttonSeeMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Commands.openKeyboard();
				Commands.addToTicket(Commands.ticketSpacing("SEE ME", Double.parseDouble("0.00")), Double.parseDouble("0.00"));
			}
		});
		
		totalPrice = new JTextField("$0.00");
		totalPrice.setBounds(275, Vars.dimensionFullScreen.height - 100, (Vars.dimensionFullScreen.width / 3) - 265, 90);
		totalPrice.setEditable(false);
		totalPrice.setHorizontalAlignment(JTextField.CENTER);
		totalPrice.setFont(new Font("Lucida Console", Font.PLAIN, 20));
		totalPrice.setBackground(Color.white);

		itemsPanel.setLayout(null);
		itemsPanel.setBackground(new Color(200, 200, 200));
		
		scrollPane = new JScrollPane(itemsPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(5, 0, (Vars.dimensionFullScreen.width / 3) - 10, Vars.dimensionFullScreen.height - 100);
		itemsPanel.setBounds(10, 5, (Vars.dimensionFullScreen.width / 3) - 5, Vars.dimensionFullScreen.height - 5);
		panel.setBounds((Vars.dimensionFullScreen.width * 2 / 3), 0, (Vars.dimensionFullScreen.width / 3),Vars.dimensionFullScreen.height);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		panel.add(scrollPane);
		panel.add(totalPrice);
		panel.add(buttonSeeMe);
		refresh();
	}
	
	public static void removeSelectedItem() {
		for(int x = 0; x < ticketItems.size(); x++) {
			if(ticketItems.get(x).isSelected()) {
				Commands.removeFromTicket(x);
				removeSelectedItem();
			}
		}
	}
	
	public static double getPrice() {
		double temp = 0.0;
		for(int x = 0; x < ticketItems.size(); x++) {
			temp+=ticketItems.get(x).getPrice();
		}
		return temp;
	}
	
	public static void refresh() {
		itemsPanel.removeAll();
		for(int x = 0; x < ticketItems.size(); x++) {
			ticketItems.get(x).setFont(new Font("Lucida Console", Font.PLAIN, 15));
			ticketItems.get(x).setBackground(new Color(200, 200, 200));
			ticketItems.get(x).setBounds(5, buttonSize*x, (Vars.dimensionFullScreen.width / 3) - 45, buttonSize);
			ticketItems.get(x).setIndex(x);
			itemsPanel.add(ticketItems.get(x));
		}
		itemsPanel.setPreferredSize(new Dimension((Vars.dimensionFullScreen.width / 3) - 5, (ticketItems.size()*buttonSize)));
		String price = Double.toString(getPrice());
		totalPrice.setText("$"+ formatter.format(Double.parseDouble(price)));
	}
}
