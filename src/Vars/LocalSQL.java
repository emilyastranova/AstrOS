package Vars;

import java.util.ArrayList;

import Commands.SQL;
import Main.MenuItem;

public class LocalSQL {

	public static ArrayList<ArrayList<String>> Login;
	public static ArrayList<ArrayList<String>> Appetizers;
	public static ArrayList<ArrayList<String>> Entrees;
	public static ArrayList<ArrayList<String>> Pizza;
	public static ArrayList<ArrayList<String>> Subs;
	public static ArrayList<ArrayList<String>> AllItemsAndOptions;
	public static ArrayList<ArrayList<String>> Opt_ALL;
	public static int numOfItems;

	public LocalSQL() {
		SQL.initConnect();

		Login = SQL.returnTable("Login", "Name", "ID");
		Appetizers = SQL.returnTable("Appetizers", "Items", "Price");
		Entrees = SQL.returnTable("Entrees", "Items", "Price");
		Pizza = SQL.returnTable("Pizza", "Items", "Price");
		Subs = SQL.returnTable("Subs", "Items", "Price");
		Opt_ALL = SQL.returnTable("Opt_ALL", "Options", "Price");
		numOfItems = Appetizers.size() + Entrees.size() + Pizza.size() + Subs.size();
		
		for (int i = 0; i < numOfItems; i++) {
			AllItemsAndOptions.add(new ArrayList<String>());
		}

		SQL.closeConnection();
	}

	public static void main(String[] Args) {
		LocalSQL test = new LocalSQL();
	}
}