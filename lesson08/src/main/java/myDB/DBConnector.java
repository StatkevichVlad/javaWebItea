package myDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static DBConnector instance;

	private DBConnector() {
		try {
			// The newInstance() call is a work around for some
			// broken Java implementations

			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			// handle the error
		}
	}
	
	public static DBConnector getInstance() {
		if (instance == null) {
			instance = new DBConnector();
		}
		return instance;
		
	}

	public Connection getConnection() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test?" + "user=root&password");

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		return conn;

	}
}
