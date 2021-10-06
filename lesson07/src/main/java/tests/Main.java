package tests;

import java.sql.SQLException;

import daoFactory.DaoFactory;

public class Main {

	public static void main(String[] args) {
		DaoFactory daoFactory = DaoFactory.getDaoFactory(1);
		try {
			daoFactory.getUserDao().addUser("administrator1", "admin", "123", "M", "DNR", "login admin, password 123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
