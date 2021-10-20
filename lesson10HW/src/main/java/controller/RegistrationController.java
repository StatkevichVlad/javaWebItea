package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoFactory.DaoFactory;


public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean success;

	public RegistrationController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/registration.jsp");
		rd.forward(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isError = false;
		List <String >errorText = new ArrayList<>();
		

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordRepeat = request.getParameter("passwordRepeat");
		String gender = request.getParameter("gender");
		String region = request.getParameter("region");
		String comment = request.getParameter("comment");
		String browser = request.getParameter("browser");
		String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		String emailPattern = "^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}";
		String result = null;

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

		if (!isError) {
			DaoFactory daoFactory = DaoFactory.getDaoFactory(1);
			try {
				daoFactory.getUserDao().addUser(name, email, password, gender, region, comment);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			result = "Registration succeeded.";
			success = true;
			
		}
		
		
		request.setAttribute("errorText", errorText);
		request.setAttribute("result", result);
		request.setAttribute("success", success);
		
		doGet(request, response);
		
	}

}
