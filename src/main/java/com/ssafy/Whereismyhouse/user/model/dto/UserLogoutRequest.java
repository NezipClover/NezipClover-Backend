package com.ssafy.Whereismyhouse.user.model.dto;

public class UserLogoutRequest {
	String email, accessToken;

	public UserLogoutRequest(String email, String accessToken) {
		super();
		this.email = email;
		this.accessToken = accessToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccessToken() {
		return accessToken;
	}

	@Override
	public String toString() {
		return "UserLogoutRequest [email=" + email + ", accessToken=" + accessToken + "]";
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
}
