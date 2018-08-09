package AdminPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import Commands.Commands;
import Commands.SQL;
import Main.Main;
import Panels.AdminSettings;
import Vars.Vars;

public class AddMenuItem extends JFrame {
	private static final long serialVersionUID = 1L;
	public static JPanel panel = new JPanel();

	public AddMenuItem() {
		panel.setLayout(null);
		panel.setBackground(new Color(20, 20, 24));

		JLabel labelItemName = new JLabel("Item Name: ");
		labelItemName.setHorizontalAlignment(JLabel.CENTER);
		labelItemName.setFont(Vars.fontDefault);
		labelItemName.setBounds(0, 0, 400, 75);
		labelItemName.setFont(Vars.fontGoogle);
		labelItemName.setForeground(Color.white);
		panel.add(labelItemName);

		JTextField textItemName = new JTextField("Item Name");
		textItemName.setHorizontalAlignment(JLabel.LEFT);
		textItemName.setFont(Vars.fontDefault);
		textItemName.setBounds(25, 60, 335, 45);
		textItemName.setFont(Vars.fontGoogle);
		textItemName.setForeground(Color.GRAY);
		textItemName.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (textItemName.getText().equals(""))
					textItemName.setText("Item Name");
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (textItemName.getText().equals("Item Name"))
					textItemName.setText("");
			}
		});
		panel.add(textItemName);

		JLabel labelPrice = new JLabel("Price: ");
		labelPrice.setHorizontalAlignment(JLabel.CENTER);
		labelPrice.setFont(Vars.fontDefault);
		labelPrice.setBounds(0, 0, 400, 275);
		labelPrice.setFont(Vars.fontGoogle);
		labelPrice.setForeground(Color.white);
		panel.add(labelPrice);

		JTextField textPrice = new JTextField("Price");
		textPrice.setHorizontalAlignment(JLabel.LEFT);
		textPrice.setFont(Vars.fontDefault);
		textPrice.setBounds(25, 160, 335, 45);
		textPrice.setFont(Vars.fontGoogle);
		textPrice.setForeground(Color.GRAY);
		textPrice.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (textPrice.getText().equals(""))
					textPrice.setText("Price");
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (textPrice.getText().equals("Price"))
					textPrice.setText("");
			}
		});
		panel.add(textPrice);

		JLabel labelCategory = new JLabel("Category: ");
		labelCategory.setHorizontalAlignment(JLabel.CENTER);
		labelCategory.setFont(Vars.fontDefault);
		labelCategory.setBounds(0, 0, 400, 475);
		labelCategory.setFont(Vars.fontGoogle);
		labelCategory.setForeground(Color.white);
		panel.add(labelCategory);

		String[] comboCategoryItems = { "Appetizers", "Entrees", "Pizza", "Subs" };
		JComboBox<String> comboCategory = new JComboBox<String>(comboCategoryItems);
		comboCategory.setEditable(false);
		comboCategory.setFont(Vars.fontGoogle);
		comboCategory.setBounds(25, 260, 335, 45);
		comboCategory.setForeground(Color.GRAY);
		panel.add(comboCategory);

		AdminButton buttonSubmit = new AdminButton();
		buttonSubmit.setText("SUBMIT");
		buttonSubmit.setFont(Commands.changeFontSize(20, Vars.fontGoogle));
		buttonSubmit.setBorder(null);
		buttonSubmit.setBounds(135, 325, 100, 60);
		buttonSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanels.Loading temp = new AdminPanels.Loading();
				Timer tempTime = new Timer(100, new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						ArrayList<String> Columns = new ArrayList<String>();
						ArrayList<String> Values = new ArrayList<String>();
						Columns.add("Items");
						Columns.add("Price");
						Values.add(textItemName.getText());
						Values.add(textPrice.getText());
						SQL.initConnect();
						SQL.addRow(comboCategoryItems[comboCategory.getSelectedIndex()], Columns, Values);
						SQL.createOptionTable(textItemName.getText());
						AdminSettings.panelMenuItems.refresh();
						AdminSettings.panelOptions.refresh();
						SQL.closeConnection();
						temp.dispose();
					}
				});
				tempTime.start();
				tempTime.setRepeats(false);
				AdminSettings.frameAddMenuItem.setVisible(false);
			}
		});
		panel.add(buttonSubmit);

		panel.setVisible(true);

		add(panel);
		setSize(new Dimension(400, 450));
		Main.centerWindow(this);
		setTitle("Add Menu Item");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String args[]) {
		new AddMenuItem();
	}

}
