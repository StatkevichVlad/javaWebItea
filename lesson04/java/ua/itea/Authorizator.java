package ua.itea;

import java.util.Objects;

import myDB.DBExecutor;

public class Authorizator {

	public String isAuthorized(String login, String password) {
		DBExecutor dbExecutor =  new DBExecutor();
		return dbExecutor.checkLogin(login, password);
	}
}


