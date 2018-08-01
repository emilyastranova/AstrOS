package Main;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Panels.*;
import Vars.Vars;
import Commands.SQL;

public class Main extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public static JFrame MainFrame;
	public static JPanel panelHome;
	public static JPanel panelSignIn;
	public static JPanel panelStartUp;
	public static JPanel panelAdminLogin;
	public static JPanel panelAdminSettings;
	public static JPanel panelLoading;
	

	public Main() {
		createView(getGraphics());
		
		setTitle(Vars.Title);
		setPreferredSize(Vars.dimensionFullScreen);
		//setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		pack();
	}
	
	public void createView(Graphics g) {
		Home.createView(getGraphics());
		panelHome = Home.panel;
		SignIn.createView(getGraphics());
		panelSignIn = SignIn.panel;
		StartUp.createView(getGraphics());
		panelStartUp = StartUp.panel;
		AdminLogin.createView(getGraphics());
		panelAdminLogin = AdminLogin.panel;
		AdminSettings.createView(getGraphics());
		panelAdminSettings = AdminSettings.panel;
		Loading.createView(getGraphics());
		panelLoading = Loading.panel;
		
		getContentPane().add(panelStartUp);
	}
	
	public static void main(String[] Args) {
		
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainFrame = new Main();
				MainFrame.setVisible(true);
			}
		});
		
	}
	
}
