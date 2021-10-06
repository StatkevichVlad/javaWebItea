package model;

import java.sql.SQLException;

import daoFactory.DaoFactory;
import mySql.MySQLDaoFactory;

public class Authorizator {
	public String isAuthorized(String login, String password) throws SQLException {
		DaoFactory daoFactory = DaoFactory.getDaoFactory(1);
		return daoFactory.getUserDao().checkLogin(login, password);
	}

}
