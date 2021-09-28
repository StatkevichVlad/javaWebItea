package myDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBExecutor {
	public static final String SELECT_USER = "SELECT name FROM users WHERE login=? AND password =?";
	public static final String INSERT_USER = "INSERT INTO users (name , login , password, gender , region , comment)  VALUES(?,?,?,?,?,?)";

	String name;

	public String checkLogin(String login, String password) {
		Connection conn = DBConnector.getInstance().getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(SELECT_USER);
			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				name = rs.getString(1);
			}
		} catch (SQLException e) {

		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException ex) {

			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {

			}

		}
		return name;
	}

	public void addUser(String name, String login, String password , String gender , String region , String comment) {
		Connection conn = DBConnector.getInstance().getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(INSERT_USER);
			ps.setString(1, name);
			ps.setString(2, login);
			ps.setString(3, password);
			ps.setString(4, gender);
			ps.setString(5, region);
			ps.setString(6, comment);
			ps.executeUpdate();
		} catch (SQLException e) {
			try {
				conn.close();
			} catch (SQLException ex) {

			}
			finally {
				try {
					if(ps != null) {
						ps.close();
					}
				} catch (SQLException ex) {
					
				}try {
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException ex) {
					
				}
		}
	}

}
}
