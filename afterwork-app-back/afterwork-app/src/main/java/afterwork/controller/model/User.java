package afterwork.controller.model;

public class User {

	private String name;
	private String username;
	private String mail;

	public void setName(String name) {
		this.name = name;		
	}

	public String getName() {
		return this.name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return this.username;
	}

	public String getMail() {
		return this.mail;
	}

}
