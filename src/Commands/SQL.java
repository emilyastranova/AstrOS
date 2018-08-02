package Commands;
//change the capitalized strings - SERVER/DB, USER, PASSWORD, TABLE, COMUMN1 & COLUMN2

//make sure to configure the jdbc and the jdbc-bin JAR files into the buildpath
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQL {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://sql143.main-hosting.eu/u888023296_pizza";
	static final String USER = "u888023296_admin";
	static final String PASS = "`VXb=me@c$==E756P8";
	public static Connection conn = null;
	public static Statement stmt = null;
	public static ResultSet rs = null;
	public static boolean isConnected = false;

	public static String currentName;
	public static String currentID;
	public static boolean isLoggedIn = false;

	public static void initConnect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Connection Established");
			isConnected = true;

			stmt = conn.createStatement();
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}
	
	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Somehow your dumbass still cant close servers");
		}
	}

	public static boolean checkSignInCode(String signInCode) {
		try {
			rs = stmt.executeQuery("SELECT * FROM `Login` WHERE ID = \"" + signInCode + "\";");
			if (rs.next()) {
				isLoggedIn = true;
				currentName = rs.getString("Name");
				currentID = rs.getString("ID");
			} else {
				isLoggedIn = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isLoggedIn;
	}
	
	public static ArrayList<String> returnTableContents(String Table, String... Columns) {
		ArrayList<String> array = new ArrayList<String>();
		try {
			rs = stmt.executeQuery("SELECT * FROM `" + Table + "`;");
			while(rs.next()) {
				for (int i = 0; i < Columns.length; i++) {
					array.add(rs.getString(Columns[i]));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return array;
	}
	
	public static ArrayList<String> returnAllContents(){
		ArrayList<String> array = new ArrayList<String>();
		try {
			rs = stmt.executeQuery("SELECT table_name FROM information_schema.tables WHERE table_schema ='u888023296_pizza';");
			while(rs.next()) {
					array.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return array;
	}

}
