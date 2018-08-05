package HomePanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Main.MenuItem;
import Vars.Vars;

public class Ticket {
	public static JPanel panel = new JPanel();
	public static JPanel itemsPanel = new JPanel();
	public static String ticket;
	public static JTextArea ticketTextArea;
	public static JScrollPane scrollPane;
	public static ArrayList<MenuItem> ticketItems = new ArrayList<MenuItem>();

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(new Color(200, 200, 200));
		panel.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.BLACK));
		
//		ticketTextArea = new JTextArea(20, 49);
//		ticketTextArea.setBounds(10, 5, (Vars.dimensionFullScreen.width / 3) - 5, Vars.dimensionFullScreen.height - 5);
//		ticketTextArea.setEditable(false);
//		ticketTextArea.setFont(new Font("Lucida Console", Font.PLAIN, 15));
//		ticketTextArea.setBackground(new Color(200, 200, 200));

		itemsPanel.setLayout(null);
		itemsPanel.setBounds(10, 5, (Vars.dimensionFullScreen.width / 3) - 5, Vars.dimensionFullScreen.height - 5);
		itemsPanel.setBackground(new Color(200, 200, 200));
		
		scrollPane = new JScrollPane(itemsPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(5, 0, (Vars.dimensionFullScreen.width / 3) - 10, Vars.dimensionFullScreen.height - 30);
		itemsPanel.setBounds(5, 0, (Vars.dimensionFullScreen.width / 3) - 10, Vars.dimensionFullScreen.height);
		panel.setBounds((Vars.dimensionFullScreen.width * 2 / 3), 0, (Vars.dimensionFullScreen.width / 3),Vars.dimensionFullScreen.height);
		refresh();
		panel.add(scrollPane);

	}
	
	public static void refresh() {
		itemsPanel.removeAll();
		for(int x = 0; x < ticketItems.size(); x++) {
			JButton temp = new JButton(ticketItems.get(x).toString());
			temp.setFont(new Font("Lucida Console", Font.PLAIN, 15));
			temp.setBackground(new Color(200, 200, 200));
			temp.setBounds(5, 50*x, (Vars.dimensionFullScreen.width / 3) - 5, 50);
			itemsPanel.add(temp);
			scrollPane.getViewport().revalidate();
			System.out.println(ticketItems);
		}
	}
}
