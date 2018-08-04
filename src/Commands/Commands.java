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

import HomePanels.Ticket;
import Main.Main;
import Main.MenuItem;
import Panels.Add;
import Panels.Home;
import Vars.Vars;

public class Commands {
	
	public static MenuItem buttonAdd;
	public static MenuItem buttonRemove;

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
		int numOfSpaces = 46 - totalLen;

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
			numOfSpaces = 40 - totalLen;
		} else {
			numOfSpaces = 46 - totalLen;
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

	public static MenuItem createOptionItemButton(String name, int x, int y) {
		MenuItem button = new MenuItem(Vars.colorDefaultOptionButton, Vars.colorDefaultFont);
		button.setButtonText(buttonText(name, "50px"));
		button.setBounds(x, y, 95, 100);
		button.setMargin(new Insets(0, 0, 0, 0));
		button.setFont(Commands.changeFontSize(15));
		button.setBackground(new Color(255, 255, 0));
		return button;
	}
	
	public static String buttonText(String text, String width) {
        String content1 = "<html>" +
            "<body style='text-align: center; width: ";
        String content2 = "'>" + "<p>";
        String content3 = "</p>";
        final String content = content1 + width + content2 + text + content3;
        return content;
    }

	public static MenuItem createMenuItemButton(String name, int x, int y) {
		MenuItem button = new MenuItem(Vars.colorDefaultMenuItemButton, Vars.colorDefaultFont);
		button.setButtonText(name);
		button.setBounds(x, y, 200, 100);
		button.setHorizontalAlignment(JButton.CENTER);
		button.setVerticalAlignment(JButton.CENTER);
		button.setFont(Commands.changeFontSize(20));
		button.setBackground(new Color(0, 255, 0));
		return button;
	}
	
	public static void removeFromTicket(int line) {
		System.out.println(Ticket.ticketText.substring(line * 50, (line * 50) + 48));
		Ticket.ticketText.replace(Ticket.ticketText.substring(line * 50, (line * 50) + 48), "");
		Ticket.ticketTextArea.setText(Ticket.ticketText);
		Ticket.panel.setVisible(false);
		Ticket.panel.setVisible(true);	
		System.out.println(Ticket.ticketTextArea.getText());
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
	
	public static void createAddandRemoveButtons() {
		buttonAdd = new MenuItem(Color.GREEN, Vars.colorDefaultFont);
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
		
		buttonRemove = new MenuItem(Color.RED, Vars.colorDefaultFont);
		buttonRemove.setButtonText(Commands.buttonText("REMOVE -", "25px"));
		buttonRemove.setBounds(805, 110, 105, 100);
		buttonRemove.setMargin(new Insets(0, 0, 0, 0));
		buttonRemove.setFont(Commands.changeFontSize(15));
		buttonRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeFromTicket(0);
			}
		});
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
