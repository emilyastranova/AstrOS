package Commands;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import HomePanels.Ticket;
import Main.Main;
import Main.MenuItem;
import Vars.Vars;

public class Commands {
	
	public static String ticketSpacing(String str, double doublePrice) {
		String spaces = "";
		String finalString;
		String price = Double.toString(doublePrice);
		if (price.endsWith(".0")) {
			price += "0";
		}
		
		int strLen = str.length();
		int priceLen = price.length();
		int totalLen = strLen + priceLen;
		int numOfSpaces = 47 - totalLen;

		for (int i = 0; i < numOfSpaces; i++) {
			spaces += " ";
		}

		finalString = str + spaces + "$" + price + "\n";
		return finalString;
	}

	public static MenuItem createOptionItemButton(String name, int x, int y) {
		MenuItem button = new MenuItem(Vars.colorDefaultOptionButton, Vars.colorDefaultFont);
		button.setButtonText(name);
		button.setBounds(x, y, 150, 100);
		button.setFont(Commands.changeFontSize(15));
		button.setBackground(new Color(255, 255, 0));
		return button;
	}

	public static MenuItem createMenuItemButton(String name, int x, int y) {
		MenuItem button = new MenuItem(Vars.colorDefaultMenuItemButton, Vars.colorDefaultFont);
		button.setButtonText(name);
		button.setBounds(x, y, 200, 100);
		button.setHorizontalAlignment(JButton.CENTER);
		button.setVerticalAlignment(JButton.CENTER);
		button.setFont(Commands.changeFontSize(20));
		button.setBackground(new Color(0, 255, 0));
		/*button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options.switchPanel(panelNew);
			}
		});*/
		return button;
	}

	public static void add2Ticket(String str) {
		if (Ticket.ticketText != null) {
			Ticket.ticketText += str;
		} else {
			Ticket.ticketText = str;
		}
		Ticket.ticketTextArea.setText(Ticket.ticketText);
		Ticket.panel.setVisible(false);
		Ticket.panel.setVisible(true);
	}

	public static void changeButtonColor(MenuItem button, Color normal) {
		button.normalColor = normal;
		button.lightColor = normal.brighter();
		button.darkColor = normal.darker();
		button.repaint();
	}

	public static MenuItem createHeaderButton(String name, int x) {
		MenuItem button = new MenuItem(Vars.colorDefaultHeaderButton, Vars.colorDefaultFont);
		button.setText(name);
		button.setBounds(x, 5, 200, 100);
		button.setFont(changeFontSize(25));
		return button;
	}

	public static Font changeFontSize(int fontSize) {
		Font font = new Font(Vars.fontDefault.getFontName(), Font.PLAIN, fontSize);
		return font;
	}

	public static void switchPanels(JPanel panelOld, JPanel panelNew) {
		Main.MainFrame.getContentPane().remove(panelOld);
		Main.MainFrame.getContentPane().add(panelNew);
		Main.MainFrame.setVisible(false);
		Main.MainFrame.setVisible(true);
	}

	public static String removeLastChar(String str) {
		str = str.substring(0, str.length() - 1);
		return str;
	}

	public static MenuItem createButton(String Text, int x, int y, int width, int height, boolean centered) {
		MenuItem button = new MenuItem(Vars.colorDefualtButton, Vars.colorDefaultFont);
		button.setText(Text);
		button.setFont(Vars.fontDefault);
		if (!centered) {
			button.setBounds(x, y, width, height);
		} else if (centered) {
			button.setBounds((x - (width / 2)), (y - (height / 2)), width, height);
		}
		return button;
	}

	public static JLabel createLabel(String text, int x, int y, int width) {
		JLabel label = new JLabel();
		label.setFont(Vars.fontDefault);
		label.setBounds(x, y, width, 500);
		label.setText(text);
		return label;
	}

	public static JLabel createLabel(String text, int x, int y, int width, int size) {
		JLabel label = new JLabel(text);
		label.setBounds(x, y, width, size + 5);
		label.setFont(Vars.fontDefault);
		return label;
	}
	
	public static ArrayList<String> to1dArrayList(ArrayList<ArrayList<String>> ArrayList2d) {
		ArrayList<String> ArrayList = new ArrayList<String>();
		if (ArrayList2d.size() == 1) {
			for (int i = 0; i < ArrayList2d.get(0).size(); i++) {
				ArrayList.add(ArrayList2d.get(0).get(i));
			}
		}
		
		return ArrayList;
	}
}
