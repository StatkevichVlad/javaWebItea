package springstore.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;
import springstore.dao.DaoFactory;

@Service
public class AuthService {
	private DaoFactory daoFactory;
	
	public String checkLogin(String login, String password) {
		daoFactory= daoFactory.getDaoFactory(1);
		String result = null;
		try {
			result =  daoFactory.getUserDao().checkLogin(login, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
}
