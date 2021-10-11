package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.Authorizator;

/**
 * Servlet implementation class AuthController
 */
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("logout") != null) {
			HttpSession session = request.getSession();
			session.setAttribute("authorized", null);
		}

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/login.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String result = null;
		String userName = null;
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		String loginFromSession = (String) session.getAttribute("authorized");

		Authorizator auth = new Authorizator();

		try {
			userName = auth.isAuthorized(login, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (userName != null) {
			result = userName;
			session.setAttribute("authorized", userName);
			loginFromSession = userName;
		} else {
			result = "Acces denied";
		}

		request.setAttribute("result", result);

		doGet(request, response);

	}

}
