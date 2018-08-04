package HomePanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Vars.Vars;

public class Ticket {
	public static JPanel panel = new JPanel();
	public static String ticket;
	public static String ticketText;
	public static JTextArea ticketTextArea;
	public static JScrollPane scrollPane;
	public static ArrayList<Double> prices = new ArrayList<Double>();
	public static int currentLine = 0;

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(new Color(200, 200, 200));
		panel.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.BLACK));
		
		ticketTextArea = new JTextArea(20, 49);
		ticketTextArea.setBounds(10, 5, (Vars.dimensionFullScreen.width / 3) - 5, Vars.dimensionFullScreen.height - 5);
		ticketTextArea.setEditable(false);
		ticketTextArea.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		ticketTextArea.setBackground(new Color(200, 200, 200));

		scrollPane = new JScrollPane(ticketTextArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(5, 0, (Vars.dimensionFullScreen.width / 3) - 10, Vars.dimensionFullScreen.height - 30);
		panel.add(scrollPane);

		panel.setBounds((Vars.dimensionFullScreen.width * 2 / 3), 0, (Vars.dimensionFullScreen.width / 3),Vars.dimensionFullScreen.height);
	}
}
