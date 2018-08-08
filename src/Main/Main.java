package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Commands.SQL;
import Panels.Add;
import Panels.AdminLogin;
import Panels.AdminSettings;
import Panels.Home;
import Panels.Loading;
import Panels.SignIn;
import Panels.StartUp;
import Vars.LocalSQL;
import Vars.Vars;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JFrame MainFrame;
	public static JPanel panelHome;
	public static JPanel panelSignIn;
	public static JPanel panelStartUp;
	public static JPanel panelAdminLogin;
	public static JPanel panelAdminSettings;
	public static JPanel panelLoading;
	public static JPanel panelAdd;
	public static JLayeredPane seeMe;

	public Main() {
		createView(getGraphics());

		setTitle(Vars.Title);
		setPreferredSize(Vars.dimensionFullScreen);
		// setExtendedState(JFrame.MAXIMIZED_BOTH);
		// setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		pack();

	}

	public void createView(Graphics g) {
		Add.createView(getGraphics());
		panelAdd = Add.panel;
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

		getContentPane().add(panelAdminSettings);
	}
	
	public static void centerWindow(Window frame) {
	      Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	      int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	      int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	      frame.setLocation(x, y);
	  }

	public static BufferedImage img = null;
	public static void main(String[] Args) {
		try {
			img = ImageIO.read(new File("astro.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		new LocalSQL();
		if (!SQL.isConnected) {
			System.exit(0);
		}
		System.out.println("Creating Views...");

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainFrame = new Main();
				MainFrame.setIconImage(img);
				MainFrame.setVisible(true);
				centerWindow(MainFrame);
			}
		});

	}

}
