package com.example.projectIsa.users.dto;

public class AccessTokenDTO {

    private UserLoginDTO user;
    private String accessToken;
    private Long expiresIn;
    
	public UserLoginDTO getUser() {
		return user;
	}
	public void setUser(UserLoginDTO user) {
		this.user = user;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public Long getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}
}
