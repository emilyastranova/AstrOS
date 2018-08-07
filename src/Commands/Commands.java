package Commands;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import HomePanels.Ticket;
import Main.Main;
import Main.MenuItem;
import Main.MenuItemButton;
import Panels.Add;
import Vars.Vars;

public class Commands {

	public static MenuItemButton buttonAdd;
	public static MenuItemButton buttonRemove;

	public static String ticketSpacing(String name, double doublePrice) {
		String spaces = "";
		String finalString;
		String price = Double.toString(doublePrice);
		if (price.endsWith(".0")) {
			price += "0";
		}

		int strLen = name.length();
		int priceLen = price.length();
		int totalLen = strLen + priceLen;
		int numOfSpaces = 40 - totalLen;

		for (int i = 0; i < numOfSpaces; i++) {
			spaces += " ";
		}

		finalString = name + spaces + "$" + price + "\n";
		return finalString;
	}

	public static String ticketSpacing(String name, double doublePrice, boolean isOption) {
		String spaces = "";
		String finalString;
		String price = Double.toString(doublePrice);
		if (price.endsWith(".0")) {
			price += "0";
		}

		int strLen = name.length();
		int priceLen = price.length();
		int totalLen = strLen + priceLen;
		int numOfSpaces;
		if (isOption) {
			numOfSpaces = 34 - totalLen;
		} else {
			numOfSpaces = 40 - totalLen;
		}

		for (int i = 0; i < numOfSpaces; i++) {
			spaces += " ";
		}
		if (isOption) {
			finalString = "    - " + name + spaces + "$" + price + "\n";
		} else {
			finalString = name + spaces + "$" + price + "\n";
		}
		return finalString;
	}

	public static JTextField createRemoveItem(String text, int y) {
		JTextField field = new JTextField();
		field.setText(text);
		field.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		field.setEditable(false);
		field.setBounds(5, y, (Vars.dimensionFullScreen.width / 3) - 5, 20);
		return field;
	}

	public static MenuItemButton createOptionItemButton(String name, int x, int y) {
		MenuItemButton button = new MenuItemButton(Vars.colorDefaultOptionButton, Vars.colorDefaultFont);
		button.setButtonText(buttonText(name, "50px"));
		button.setBounds(x, y, 95, 100);
		button.setMargin(new Insets(0, 0, 0, 0));
		button.setFont(Commands.changeFontSize(15));
		return button;
	}

	public static String buttonText(String text, String width) {
		String content1 = "<html>" + "<body style='text-align: center; width: ";
		String content2 = "'>" + "<p>";
		String content3 = "</p>";
		final String content = content1 + width + content2 + text + content3;
		return content;
	}

	public static MenuItemButton createMenuItemButton(String name, int x, int y, double price) {
		MenuItemButton button = new MenuItemButton(Vars.colorDefaultMenuItemButton, Vars.colorDefaultFont);
		button.setButtonText(name);
		button.setBounds(x, y, 200, 100);
		button.setHorizontalAlignment(JButton.CENTER);
		button.setVerticalAlignment(JButton.CENTER);
		button.setFont(Commands.changeFontSize(20));
		button.setPrice(price);
		return button;
	}

	public static void refreshTicket() {
		Ticket.refresh();
		Ticket.panel.setVisible(false);
		Ticket.panel.setVisible(true);
	}

	public static void removeFromTicket(int line) {
		if(!Ticket.ticketItems.isEmpty())
		Ticket.ticketItems.remove(line);
		refreshTicket();
	}

	public static void addToTicket(String str, Double price) {
		Ticket.ticketItems.add(new MenuItem(str, price));
		refreshTicket();
	}

	public static void changeButtonColor(MenuItemButton button, Color normal) {
		button.normalColor = normal;
		button.lightColor = normal.brighter();
		button.darkColor = normal.darker();
		button.repaint();
	}

	public static MenuItemButton createHeaderButton(String name, int x) {
		MenuItemButton button = new MenuItemButton(Vars.colorDefaultHeaderButton, Vars.colorDefaultFont);
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

	public static void createAddandRemoveButtons() {
		buttonAdd = new MenuItemButton(Color.GREEN, Vars.colorDefaultFont);
		buttonAdd.setButtonText(Commands.buttonText("ADD +", "25px"));
		buttonAdd.setBounds(805, 5, 105, 100);
		buttonAdd.setMargin(new Insets(0, 0, 0, 0));
		buttonAdd.setFont(Commands.changeFontSize(15));
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add.panel.add(Ticket.panel);
				switchPanels(Main.panelHome, Main.panelAdd);
			}
		});

		//THIS IS THE REMOVE BUTTON
		buttonRemove = new MenuItemButton(Color.RED, Vars.colorDefaultFont);
		buttonRemove.setButtonText(Commands.buttonText("REMOVE -", "25px"));
		buttonRemove.setBounds(805, 110, 105, 100);
		buttonRemove.setMargin(new Insets(0, 0, 0, 0));
		buttonRemove.setFont(Commands.changeFontSize(15));
		buttonRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				Ticket.removeSelectedItem();
			}
		});
	}

	public static String removeLastChar(String str) {
		str = str.substring(0, str.length() - 1);
		return str;
	}

	public static MenuItemButton createButton(String Text, int x, int y, int width, int height, boolean centered) {
		MenuItemButton button = new MenuItemButton(Vars.colorDefaultButton, Vars.colorDefaultFont);
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
