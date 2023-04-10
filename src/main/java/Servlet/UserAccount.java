package Servlet;

public class UserAccount {

	private String Username;
	private String Phone;
	private String Password;

	public UserAccount() {
	}

	public UserAccount(String username, String phone, String password) {
		Username = username;
		Phone = phone;
		Password = password;
	}

	public UserAccount(UserAccount us) {
		Username = Username;
		Phone = Phone;
		Password = Password;
	}

	public UserAccount(String username, String password) {
		Username = username;
		Password = password;
	}

	public UserAccount(String username) {
		Username = username;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
}
