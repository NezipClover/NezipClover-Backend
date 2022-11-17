package com.ssafy.Whereismyhouse.user.model.dto;

public class User {

	private String email;
	private String name;
	private String password;
	
	public User() {}
	public User(String email, String name, String password) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
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
		StringBuilder builder = new StringBuilder();
		builder.append("UserDto [name=").append(name).append(", password=").append(password)
				.append(", email=").append(email).append("]");
		return builder.toString();
	}
}