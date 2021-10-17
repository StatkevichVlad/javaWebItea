package mySql;

import java.sql.SQLException;

import daoFactory.DaoFactory;

public class MainTest {

	public static void main(String[] args) throws SQLException {
	DaoFactory daoFactory = DaoFactory.getDaoFactory(1);
		
	System.out.println(	daoFactory.getProductDao().getProductByCategory("Online"));
		

	}

}
