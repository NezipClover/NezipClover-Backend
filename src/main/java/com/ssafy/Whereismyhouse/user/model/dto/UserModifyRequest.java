package com.ssafy.Whereismyhouse.user.model.dto;

public class UserModifyRequest {
	String email, name, password;
	Integer userKind;
	public UserModifyRequest(String email, String name, String password, Integer userKind) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.userKind = userKind;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public int getUserKind() {
		return userKind;
	}
	public void setUserKind(int userKind) {
		this.userKind = userKind;
	}
	@Override
	public String toString() {
		return "UserModifyRequest [email=" + email + ", name=" + name + ", password=" + password + ", userKind="
				+ userKind + "]";
	}
	
}
