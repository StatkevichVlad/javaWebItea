package springstore.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import springstore.dao.DaoFactory;

@Service
public class RegistrationService {

	private List<String> errorText;

	public RegistrationService() {
	}

	

	public List<String> getErrorList(String name, String email, String password, String passwordRepeat, String gender,
			String region, String comment, String browser) {
		boolean isError = false;
		List<String> errorText = new ArrayList<>();
		String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		String emailPattern = "^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}";
		

		String pass = password = "" + password;
		String repPass = "" + passwordRepeat;

		if (name == null || name.isEmpty()) {
			isError = true;
			errorText.add("Enter your name!");
		}

		if (email == null || email.isEmpty() || !email.matches(emailPattern)) {
			isError = true;
			errorText.add("Email error! Check your email.");
		}

		if (!pass.equals(repPass) || !pass.matches(passwordPattern)) {
			isError = true;
			errorText.add("Password error!");
		}

		if (gender == null) {
			isError = true;
			errorText.add("Choose gender!");
		}

		if (comment == null || comment.isEmpty()) {
			isError = true;
			errorText.add("Enter your comment , please.");
		}

		if (browser == null) {
			isError = true;
			errorText.add("Check for install AMIGO BROWSER! THE BEST BROWSER IN THE WORLD.");
		}

		return errorText;
	}

	public String registrated(String name,String email,String password,String gender,String region,String comment) {
		String result = "Denied";
		DaoFactory daoFactory = DaoFactory.getDaoFactory(1);
		try {
			daoFactory.getUserDao().addUser(name, email, password, gender, region, comment);
			result = "registration Succes";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	

}
