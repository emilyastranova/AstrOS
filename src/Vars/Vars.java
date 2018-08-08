package Vars;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

public class Vars {
	public static final String Title = "AstroOS";
	public static final String MasterPassword = "tt";
	public static String currentName;
	public static String currentID;

	public static final Dimension dimensionFullScreen = new Dimension(1280, 720);

	public static final Color colorMainBG = new Color(250, 250, 250);
	public static final Color colorDefaultButton = new Color(250, 250, 250);
	public static final Color colorDefaultHeaderButton = new Color(255, 0, 0);
	public static final Color colorDefaultHeaderButtonSelected = new Color(0, 0, 255);
	public static final Color colorDefaultMenuItemButton = new Color(0, 255, 0);
	public static final Color colorDefaultOptionButton = new Color(255, 255, 0);
	public static final Color colorDefaultFont = new Color(0, 0, 0);
	public static final Color colorDefaultSelected = Color.BLUE;

	public static final Font fontDefault = new Font("Arial", Font.PLAIN, 30);
	public static final Font fontDefaultAdminPanels = new Font("Product Sans Regular", Font.PLAIN, 30);
	public static final Font googleFont = new Font("Roboto", Font.PLAIN, 30);

	public static final int halfScreenWidth = dimensionFullScreen.width / 2;
	public static final int halfScreenHeight = dimensionFullScreen.height / 2;
	
}
