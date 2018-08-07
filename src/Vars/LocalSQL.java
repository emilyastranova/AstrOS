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
	
	public static ArrayList<ArrayList<String>> AllItems;
	
	public static ArrayList<ArrayList<String>> Opt_ALL;
	
	public LocalSQL() {
		SQL.initConnect();
		
		Login = SQL.returnTable("Login", "Name", "ID");
		Appetizers = SQL.returnTable("Appetizers", "Items", "Price");
		Entrees = SQL.returnTable("Entrees", "Items", "Price");
		Pizza = SQL.returnTable("Pizza", "Items", "Price");
		Subs = SQL.returnTable("Subs", "Items", "Price");
		Opt_ALL = SQL.returnTable("Opt_ALL", "Options", "Price");
		AllItems = new ArrayList<ArrayList<String>>();
		
		for (int i = 0; i < Appetizers.size(); i++) {
			AllItems.get(0).add(Appetizers.get(i).get(0));
		}
		
		for (int i = 0; i < Entrees.size(); i++) {
			AllItems.get(1).add(Entrees.get(i).get(0));
		}
		
		for (int i = 0; i < Pizza.size(); i++) {
			AllItems.get(2).add(Pizza.get(i).get(0));
		}
		
		for (int i = 0; i < Subs.size(); i++) {
			AllItems.get(3).add(Subs.get(i).get(0));
		}
		
		SQL.closeConnection();
	}
	
	public static void main(String[] Args) {
		LocalSQL test = new LocalSQL();
	}
}
