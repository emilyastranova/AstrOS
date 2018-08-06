package Main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Commands.Commands;

public class MenuItem extends JButton implements ActionListener {

	String name;
	double price;
	int index = 0;
	boolean selected = false;
	
	public MenuItem() {
		
	}
	
	public MenuItem(String name, double price) {
		this.name = name;
		this.price = price;
		setText(name);
		addActionListener(this);
	}
	
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		selected = !selected;
		if(selected)
			setForeground(Color.RED);
		else
			setForeground(Color.BLACK);
		
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
}
