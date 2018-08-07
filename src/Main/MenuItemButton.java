package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

;

public class MenuItemButton extends JButton implements ActionListener, MouseListener {
	private boolean hovered = false;
	private boolean clicked = false;

	public Color normalColor = null;
	public Color lightColor = null;
	public Color darkColor = null;

	public int index = 0;
	public String name = null;
	
	public MenuItemButton(Color normalRedColor, Color fontColor) {
		setForeground(fontColor);

		this.normalColor = normalRedColor;
		this.lightColor = normalRedColor.brighter();
		this.darkColor = normalRedColor.darker();
		addActionListener(this);
		addMouseListener(this);
		setContentAreaFilled(false);
	}
	
	public void setButtonText(String n) {
		name = n;
		this.setText(n);
	}

	// @Override
	// public void setBackground(Color normalRedColor) {
	// this.normalColor = normalRedColor;
	// this.lightColor = normalRedColor.brighter();
	// this.darkColor = normalRedColor.darker();
	// }

	/**
	 * Overpainting component, so it can have different colors
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		GradientPaint gp = null;

		if (clicked)
			gp = new GradientPaint(0, 0, darkColor, 0, getHeight(), darkColor.darker());
		else if (hovered)
			gp = new GradientPaint(0, 0, lightColor, 0, getHeight(), lightColor.darker());
		else
			gp = new GradientPaint(0, 0, normalColor, 0, getHeight(), normalColor.darker());

		g2d.setPaint(gp);

		// Draws the rounded opaque panel with borders
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // For High quality
		g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 7, 7);

		g2d.setColor(darkColor.darker().darker());
		g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 7, 7);

		super.paintComponent(g);
	}
	
	public void setIndex(int i) {
		index = i;
	}
	
	public int getIndex() {
		return index;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		hovered = true;
		clicked = false;

		repaint();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		hovered = false;
		clicked = false;

		repaint();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		hovered = true;
		clicked = true;

		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		hovered = true;
		clicked = false;

		repaint();
	}
}