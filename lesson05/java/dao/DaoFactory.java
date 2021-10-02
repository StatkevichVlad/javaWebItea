package dao;

import java.sql.SQLException;

public abstract class DaoFactory {
	public static final int MYSQL = 1;
	public static final int OTHER_DB = 2;

	public abstract UserDao getUserDao() throws SQLException;

	public static DaoFactory getDaoFactory(int whichFactory) {
		if (whichFactory == MYSQL) {
			return new MySQLDaoFactory();
		} else {
			return null;
		}

	}

}
