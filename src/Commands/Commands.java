package Commands;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import HomePanels.CustomColorButton;
import HomePanels.Ticket;
import Main.Main;
import Vars.Vars;

public class Commands {
	
	public static JButton createOptionItemButton(String name, int x, int y) {
		JButton button = new JButton(name);
		button.setBounds(x, y, 150, 100);
		button.setFont(Commands.changeFontSize(15));
		button.setBackground(new Color(255, 255, 0));
		return button;
	}
	
	public static JButton createMenuItemButton(String name, int x, int y) {
		JButton button = new JButton(name);
		button.setBounds(x, y, 200, 100);
		button.setHorizontalAlignment(JButton.CENTER);
		button.setVerticalAlignment(JButton.CENTER);
		button.setFont(Commands.changeFontSize(20));
		button.setBackground(new Color(0, 255, 0));
		return button;
	}
	
	public static CustomColorButton createMenuItemButton(String name, int x, int y, Color normal, Color font) {
		CustomColorButton button = new CustomColorButton(normal, font);
		button.setText(name);
		button.setBounds(x, y, 200, 100);
		button.setHorizontalAlignment(JButton.CENTER);
		button.setVerticalAlignment(JButton.CENTER);
		button.setFont(Commands.changeFontSize(20));
		button.setBackground(new Color(0, 255, 0));
		return button;
	}
	
	public static void add2Ticket(String str) {
		Ticket.ticketText += str;
		Ticket.ticketTextArea.setText(Ticket.ticketText);
		Ticket.panel.setVisible(false);
		Ticket.panel.setVisible(true);
	}
	
	public static JButton createHeaderButton(String name, int x) {
		JButton button = new JButton(name);
		button.setBounds(x, 5, 200, 100);
		button.setFont(changeFontSize(25));
		button.setBackground(Vars.colorDefaultHeaderButton);
		button.setOpaque(true);
		return button;
	}
	
	public static CustomColorButton createHeaderButton(String name, int x, Color normal) {
		CustomColorButton button = new CustomColorButton(normal, Color.black);
		button.setText(name);
		button.setBounds(x, 5, 200, 100);
		button.setFont(changeFontSize(25));
		button.setBackground(Vars.colorDefaultHeaderButton);
		button.setOpaque(true);
		return button;
	}
	
	public static Font changeFontSize(int fontSize) {
		Font font = new Font(Vars.fontDefault.getFontName(), Font.PLAIN, fontSize);
		return font;
	}
	
	public static void switchPanels (JPanel panelOld, JPanel panelNew) {
		Main.MainFrame.getContentPane().remove(panelOld);
		Main.MainFrame.getContentPane().add(panelNew);
		Main.MainFrame.setVisible(false);
		Main.MainFrame.setVisible(true);
	}
	
	public static String removeLastChar(String str) {
		str = str.substring(0, str.length() - 1);
		return str;
	}
	
	public static JButton createButton(String Text, int x, int y, int width, int height, boolean centered, int size) {
		JButton button = new JButton(Text);
		Font font = new Font(Vars.fontDefault.getFontName(), Font.PLAIN, size);
		button.setFont(font);		
		if (!centered) {
			button.setBounds(x, y, width, height);
		} else if (centered) {
			button.setBounds((x - (width / 2)), (y - (height / 2)), width, height);
		}
		return button;
	}
	
	public static JButton createButton(String Text, int x, int y, int width, int height, boolean centered) {
		JButton button = new JButton(Text);
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
}
