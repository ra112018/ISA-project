package com.example.projectIsa.users.dto;

public class AccessTokenDTO {

    private UserLoginDTO user;
    private String token;
    private Long expireTime;
    private String role;
    private int id;
    
    public AccessTokenDTO(UserLoginDTO user, String token, String role,int id, Long expireTime) {
		super();
		this.user = user;
		this.id = id;
		this.token = token;
		this.role = role;
		this.expireTime = expireTime;
	}
    
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Long getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}
	public UserLoginDTO getUser() {
		return user;
	}
	public void setUser(UserLoginDTO user) {
		this.user = user;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
