package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import myDB.DBConnector;

public class MySQLDaoFactory extends DaoFactory {
	private static DBConnector instance;
	
	

	
	public MySQLDaoFactory() {
		try {
			// The newInstance() call is a work around for some
			// broken Java implementations

			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			// handle the error
		}
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
	
	@Override
	public UserDao getUserDao() throws SQLException {
		return new MySQLUserDao();
	}

}
