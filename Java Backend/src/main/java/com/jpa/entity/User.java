package com.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Login_Tbl")
public class User {
	

	@Id
	@Column(length = 20)
	@NotBlank(message = "Username can not be blank")
	private String userName;
	@NotBlank(message = "Password can not be blank")
	private String password;
	@NotBlank(message = "Role can not be blank")
	private String role;
	
	public User() {
		super();
		
	}

	public User(@NotBlank(message = "Name can not be blank") String userName,
			@NotBlank(message = "Password can not be blank") String password,
			@NotBlank(message = "Role can not be blank") String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}

}
