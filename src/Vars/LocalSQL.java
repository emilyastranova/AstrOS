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
	public static ArrayList<OptionArrayList> Options;
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
		Options = new ArrayList<OptionArrayList>();

		// Populate 2D ArrayList of available Options based on SQL prefixes
		ArrayList<String> tempTables = new ArrayList<String>();
		tempTables = SQL.returnAllContents();
		ArrayList<String> parsedOptNames = new ArrayList<String>();
		for (int i = 0; i < tempTables.size(); i++) {

			if (tempTables.get(i).equals("Opt_ALL"))
				tempTables.remove(i);

			if (tempTables.get(i).startsWith("Opt_")) {
				parsedOptNames.add(tempTables.get(i));
			}
		}

		for(int i = 0; i < parsedOptNames.size(); i++) {
			OptionArrayList temp = new OptionArrayList();
			temp.setName(parsedOptNames.get(i));
			Options.add(temp);
		}
			

		System.out.println(Options.get(0).get(0).get(0));

		SQL.closeConnection();
		System.out.println("Connection Closed");
	}

	public void displayAppetizers() {
		System.out.println(Appetizers);
	}

	public static void main(String[] Args) {
		LocalSQL test = new LocalSQL();
	}

}