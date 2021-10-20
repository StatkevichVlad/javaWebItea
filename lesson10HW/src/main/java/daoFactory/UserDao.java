package daoFactory;


public interface UserDao {
	public String checkLogin(String login, String password);

	public void addUser(String name, String login, String password, String gender, String region, String comment);
}
