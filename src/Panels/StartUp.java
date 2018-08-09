package Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import Commands.Commands;
import Main.Main;
import Vars.Vars;

public class StartUp {
	public static JPanel panel = new JPanel();
	public static String SignInCode = "";

	public class ImagePanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private BufferedImage image;

	    public ImagePanel() {
	       try {                
	          image = ImageIO.read(new File("Resources\\AstrOS Banner.png"));
	       } catch (IOException ex) {
	            ex.printStackTrace();
	       }
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 0, 0, this);
	    }

	}

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(new Color(50, 70, 100));

        StartUp.ImagePanel image = new StartUp().new ImagePanel();
        image.setVisible(true);
        image.setBackground(new Color(50, 70, 100));
        image.setBounds(Vars.halfScreenWidth - 400, 0, 800, 500);
        panel.add(image);
		
		JButton buttonNormalStartup = Commands.createButton("<html>Click Here to Boot Normally</html>",
				Vars.halfScreenWidth - 175, Vars.halfScreenHeight + 250, 300, 80, true);
		buttonNormalStartup.setFont(new Font(Vars.fontDefault.getFontName(), Font.PLAIN, 20));
		buttonNormalStartup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Commands.switchPanels(Main.panelStartUp, Main.panelSignIn);
			}
		});
		panel.add(buttonNormalStartup);
		JButton buttonAdminStartup = Commands.createButton("<html>Click Here to Boot into<br>Administrator Mode</html>",
				Vars.halfScreenWidth + 175, Vars.halfScreenHeight + 250, 300, 80, true);
		buttonAdminStartup.setFont(new Font(Vars.fontDefault.getFontName(), Font.PLAIN, 20));
		buttonAdminStartup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Commands.switchPanels(Main.panelStartUp, Main.panelAdminLogin);
			}
		});
		panel.add(buttonAdminStartup);
	}
}