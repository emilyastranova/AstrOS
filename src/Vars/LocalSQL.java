package Vars;

import java.util.ArrayList;

import Commands.SQL;

public class LocalSQL {

	public static ArrayList<ArrayList<String>> Login;
	public static ArrayList<ArrayList<String>> Appetizers;
	public static ArrayList<ArrayList<String>> Entrees;
	public static ArrayList<ArrayList<String>> Pizza;
	public static ArrayList<ArrayList<String>> Subs;
	public static ArrayList<ArrayList<String>> Opt_ALL;
	public static ArrayList<ArrayList<String>> Options;
	public static int numOfItems;

	public LocalSQL() {
		SQL.initConnect();

		numOfItems = 0;
		Login = SQL.returnTable("Login", "Name", "ID");
		Appetizers = SQL.returnTable("Appetizers", "Items", "Price");
		Entrees = SQL.returnTable("Entrees", "Items", "Price");
		Pizza = SQL.returnTable("Pizza", "Items", "Price");
		Subs = SQL.returnTable("Subs", "Items", "Price");
		Opt_ALL = SQL.returnTable("Opt_ALL", "Options", "Price");

		SQL.closeConnection();
		System.out.println("Connection Closed");
	}

	public void displayAppetizers() {
		System.out.println(Appetizers);
	}

	public static void main(String[] Args) {
		LocalSQL test = new LocalSQL();
		test.displayAppetizers();
	}

}