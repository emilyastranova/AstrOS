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
	static final String DB_URL = "jdbc:mysql://sql143.main-hosting.eu/u888023296_pizza?autoReconnect=true";
	static final String USER = "u888023296_admin";
	static final String PASS = "`VXb=me@c$==E756P8";
	public static Connection conn = null;
	public static Statement stmt = null;
	public static ResultSet rs = null;
	public static boolean isConnected = false;

	public static void initConnect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection Established");
			isConnected = true;

			stmt = conn.createStatement();

			try {
				stmt.setQueryTimeout(300);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println("Initiation of Query Timeout Failed");
			}
		} catch (Exception exc) {
			System.err.println("Connection Failed");
			isConnected = false;
		}

	}

	public static void closeConnection() {
		try {
			conn.close();

			System.out.println("Connection Closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Closing Connection Failed :(");
		}
	}

	public static ArrayList<String> returnTableContents(String Table, String... Columns) {
		ArrayList<String> array = new ArrayList<String>();
		try {
			rs = stmt.executeQuery("SELECT * FROM `" + Table + "`;");
			while (rs.next()) {
				for (int i = 0; i < Columns.length; i++) {
					array.add(rs.getString(Columns[i]));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return array;
	}

	public static ArrayList<ArrayList<String>> returnTable(String Table, String... Columns) {
		ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
		try {
			rs = stmt.executeQuery("SELECT * FROM `" + Table + "`;");
			for (int i = 0; rs.next(); i++) {
				array.add(new ArrayList<String>());
				for (int j = 0; j < Columns.length; j++) {
					array.get(i).add(rs.getString(Columns[j]));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return array;
	}

	public static ArrayList<String> returnAllContents() {
		ArrayList<String> array = new ArrayList<String>();
		try {
			rs = stmt.executeQuery(
					"SELECT table_name FROM information_schema.tables WHERE table_schema ='u888023296_pizza';");
			while (rs.next()) {
				array.add(rs.getString(1));
			}
		} catch (SQLException e) {
			System.err.println("Statement Failed");
		}
		return array;
	}

	public static String returnPriceOfItem(String Table, String Item) {
		String index = null;
		try {
			rs = stmt.executeQuery("SELECT `Price` FROM `" + Table + "` WHERE `Items` = \"" + Item + "\"");
			if (rs.next()) {
				index = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Statement Failed");
		}
		return index;

	}

	public static String returnPriceOfOption(String Table, String Item) {
		String index = null;
		try {
			rs = stmt.executeQuery("SELECT `Price` FROM `" + Table + "` WHERE `Options` = \"" + Item + "\"");
			if (rs.next()) {
				index = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Statement Failed");
		}
		return index;

	}

	public static void removeRow(String Table, String Column, String Value) {
		try {
			stmt.executeUpdate("DELETE FROM `" + Table + "` WHERE  `" + Column + "`='" + Value + "';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Statement Failed");
		}
	}

	public static void addRow(String Table, ArrayList<String> Columns, ArrayList<String> Values) {
		String statement = "INSERT INTO `" + Table + "` (";

		for (int i = 0; i < Columns.size(); i++) {
			if (Columns.size() - 1 == i) {
				statement += "`" + Columns.get(i) + "`) VALUES (";
			} else {
				statement += "`" + Columns.get(i) + "`, ";
			}
		}

		for (int i = 0; i < Values.size(); i++) {
			if (Values.size() - 1 == i) {
				statement += "'" + Values.get(i) + "');";
			} else {
				statement += "'" + Values.get(i) + "', ";
			}
		}
		try {
			stmt.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}
	
	public static void createOptionTable(String Table) {
		try {
			stmt.executeUpdate("CREATE TABLE `Opt_" + Table + "` (`Options` VARCHAR(40) NOT NULL, `Price` VARCHAR(10) NOT NULL, PRIMARY KEY (`Options`))"); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void dropTable(String Table) {
		try {
			stmt.executeUpdate("DROP TABLE `" + Table + "`;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
