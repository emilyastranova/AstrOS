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

	public LocalSQL() {
		SQL.initConnect();

		Login = SQL.returnTable("Login", "Name", "ID");
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
		
		AllTables = new ArrayList<String>();
		try {
			SQL.rs = SQL.stmt.executeQuery("SELECT table_name FROM information_schema.tables WHERE table_schema ='u888023296_pizza';");
			while(SQL.rs.next()) {
				AllTables.add(SQL.rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		SQL.closeConnection();
	}

	public static ArrayList<ArrayList<String>> returnOptionsByName(String name) {
		for (int i = 0; i < AppetizerOptions.size(); i++) {
			if (AppetizerOptions.get(i).getName() == name) {
				return AppetizerOptions.get(i).getOptions();
			}
		}
		for (int i = 0; i < EntreeOptions.size(); i++) {
			if (EntreeOptions.get(i).getName() == name) {
				return EntreeOptions.get(i).getOptions();
			}
		}
		for (int i = 0; i < PizzaOptions.size(); i++) {
			if (PizzaOptions.get(i).getName() == name) {
				return PizzaOptions.get(i).getOptions();
			}
		}
		for (int i = 0; i < SubOptions.size(); i++) {
			if (SubOptions.get(i).getName() == name) {
				return SubOptions.get(i).getOptions();
			}
		}
		
		return null;
	}
}