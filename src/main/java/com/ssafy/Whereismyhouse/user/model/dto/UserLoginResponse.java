package com.ssafy.Whereismyhouse.user.model.dto;

public class UserLoginResponse {

	String email, name, password, result;
	int userKind;
	public UserLoginResponse(String email, String name, String password, int userKind, String result) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.result = result;
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getUserKind() {
		return userKind;
	}
	public void setUserKind(int userKind) {
		this.userKind = userKind;
	}
	@Override
	public String toString() {
		return "UserLoginResponse [email=" + email + ", name=" + name + ", password=" + password + ", result=" + result
				+ ", userKind=" + userKind + "]";
	}
	

	
}
