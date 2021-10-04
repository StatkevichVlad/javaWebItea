package model;

public class User {
	private String name;
	private String login;
	private String password;
	private String gender;
	private String region;
	private String comment;
	
	
	public User(String name, String login, String password, String gender, String region, String comment) {
		this.name = name;
		this.login = login;
		this.password = password;
		this.gender = gender;
		this.region = region;
		this.comment = comment;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
