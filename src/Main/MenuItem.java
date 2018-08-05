package Main;

public class MenuItem {

	String name;
	double price;
	
	public MenuItem() {
		
	}
	
	public MenuItem(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String toString() {
		return name;
	}
	
}
