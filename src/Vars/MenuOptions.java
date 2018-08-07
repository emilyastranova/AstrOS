package Vars;

import java.util.ArrayList;

import Commands.SQL;

public class MenuOptions {

	ArrayList<ArrayList<String>> ItemOptions;
	
	String nameOfItemTable;
	
	public MenuOptions(String name){
		setName(name);
		retreiveOptions();
	}
	
	public String getName() {
		return nameOfItemTable;
	}

	public void setName(String name) {
		this.nameOfItemTable = name;
	}

	public void retreiveOptions() {
		ItemOptions = SQL.returnTable("Opt_" + nameOfItemTable, "Options", "Price");
	}
	
	public ArrayList<ArrayList<String>> getOptions() {
		return ItemOptions;
	}
	
	public String getOptionName(int index) {
		return ItemOptions.get(index).get(0);
	}
	
	public String getOptionPrice(int index) {
		return ItemOptions.get(index).get(1);
	}
}
