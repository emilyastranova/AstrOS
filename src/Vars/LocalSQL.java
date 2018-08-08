package Vars;

import java.sql.SQLException;
import java.util.ArrayList;

import Commands.SQL;

public class LocalSQL {

	public static ArrayList<ArrayList<String>> Login;
	public static ArrayList<ArrayList<String>> Appetizers;
	public static ArrayList<ArrayList<String>> Entrees;
	public static ArrayList<ArrayList<String>> Pizza;
	public static ArrayList<ArrayList<String>> Subs;
	public static ArrayList<ArrayList<String>> Opt_ALL;
	public static ArrayList<String> AllTables;
	public static ArrayList<MenuOptions> AppetizerOptions;
	public static ArrayList<MenuOptions> EntreeOptions;
	public static ArrayList<MenuOptions> PizzaOptions;
	public static ArrayList<MenuOptions> SubOptions;
	public static boolean isLoggedIn;

	public LocalSQL() {
		SQL.initConnect();

		Login = SQL.returnTable("Login", "ID", "Name");
		Appetizers = SQL.returnTable("Appetizers", "Items", "Price");
		Entrees = SQL.returnTable("Entrees", "Items", "Price");
		Pizza = SQL.returnTable("Pizza", "Items", "Price");
		Subs = SQL.returnTable("Subs", "Items", "Price");
		Opt_ALL = SQL.returnTable("Opt_ALL", "Options", "Price");
		AppetizerOptions = new ArrayList<MenuOptions>();
		EntreeOptions = new ArrayList<MenuOptions>();
		PizzaOptions = new ArrayList<MenuOptions>();
		SubOptions = new ArrayList<MenuOptions>();
		
		for (int i = 0; i < Appetizers.size(); i++) {
			AppetizerOptions.add(new MenuOptions(Appetizers.get(i).get(0)));
		}
		for (int i = 0; i < Entrees.size(); i++) {
			EntreeOptions.add(new MenuOptions(Entrees.get(i).get(0)));
		}
		for (int i = 0; i < Pizza.size(); i++) {
			PizzaOptions.add(new MenuOptions(Pizza.get(i).get(0)));
		}
		for (int i = 0; i < Subs.size(); i++) {
			SubOptions.add(new MenuOptions(Subs.get(i).get(0)));
		}
		
		AllTables = SQL.returnAllContents();
		
		SQL.closeConnection();
	}

	public static ArrayList<ArrayList<String>> returnOptionsByName(String name) {
		for (int i = 0; i < AppetizerOptions.size(); i++) {
			if (AppetizerOptions.get(i).getName().equals(name)) {
				return AppetizerOptions.get(i).getOptions();
			}
		}
		for (int i = 0; i < EntreeOptions.size(); i++) {
			if (EntreeOptions.get(i).getName().equals(name)) {
				return EntreeOptions.get(i).getOptions();
			}
		}
		for (int i = 0; i < PizzaOptions.size(); i++) {
			if (PizzaOptions.get(i).getName().equals(name)) {
				return PizzaOptions.get(i).getOptions();
			}
		}
		for (int i = 0; i < SubOptions.size(); i++) {
			if (SubOptions.get(i).getName().equals(name)) {
				return SubOptions.get(i).getOptions();
			}
		}
		
		return null;
	}

	public static boolean checkSignInCode(String signInCode) {
		for (int i = 0; i < Login.size(); i++) {
			if (Login.get(i).get(0).equals(signInCode)) {
				isLoggedIn = true;
				Vars.currentID = Login.get(i).get(0);
				Vars.currentName = Login.get(i).get(1);
				System.out.println("Logged in using ID#: " + Vars.currentID + " - " + Vars.currentName);
			}
		}
		return isLoggedIn;
	}
}