package com.ssafy.Whereismyhouse.user.model.dto;

public class User {

	private String email;
	private String name;
	private String password;
	private int userKind;
	
	public User() {}
	public User(String email, String name, String password, int userKind) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.userKind = userKind;
	}
	

	public int getUserKind() {
		return userKind;
	}
	public void setUserKind(int userKind) {
		this.userKind = userKind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", password=" + password + ", userKind=" + userKind + "]";
	}
	

}
