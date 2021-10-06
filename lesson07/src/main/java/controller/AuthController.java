package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Authorizator;

public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean showForm = true;

	public AuthController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/auth.jsp");
		request.setAttribute("showForm", showForm);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String result = null;
		String userName = null;

		if (request.getParameter("logout") != null) {
			session.setAttribute("authorized", null);
		}

		String loginFromSession = (String) session.getAttribute("authorized");
		showForm = true;
		if (loginFromSession != null) {
			showForm = false;
		} else {
			String login = request.getParameter("login");
			String password = request.getParameter("password");

			Authorizator auth = new Authorizator();

			try {
				userName = auth.isAuthorized(login, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (userName != null) {
				showForm = false;
				result = "Acces Granted! Hello ," + userName;
				session.setAttribute("authorized", userName);
				loginFromSession = userName;
			} else {
				result = "Acces denied " + userName;
			}

		}
		request.setAttribute("result", result);
		request.setAttribute("showForm", showForm);
		doGet(request, response);

	}

}
