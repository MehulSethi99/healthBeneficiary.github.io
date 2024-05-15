package com.jpa.jwt;
import java.io.Serializable;

public class LoginData implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String userName;
	private String password;
	
	//need default constructor for JSON Parsing
	public LoginData()
	{
		
	}

	public LoginData(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginData [userName=" + userName + ", password=" + password + "]";
	}

}

