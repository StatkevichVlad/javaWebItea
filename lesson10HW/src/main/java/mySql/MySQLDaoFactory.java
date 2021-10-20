package mySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import daoFactory.DaoFactory;
import daoFactory.ProductDao;
import daoFactory.UserDao;

public class MySQLDaoFactory extends DaoFactory {
	private static MySQLDaoFactory instance;
	public static final Logger LOG = Logger.getLogger(MySQLDaoFactory.class.getName());
	
	public MySQLDaoFactory() {
		try {
	
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			LOG.info("SQL exception " +ex);
		}
	}

	public static MySQLDaoFactory getInstance() {
		if (instance == null) {
			instance = new MySQLDaoFactory();
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

	@Override
	public UserDao getUserDao() throws SQLException {

		return new MySQLUserDao();
	}

	@Override
	public ProductDao getProductDao() throws SQLException {
		// TODO Auto-generated method stub
		return new MySQLProductsDao();
	}

	

}
