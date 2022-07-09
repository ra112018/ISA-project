package com.example.projectIsa.users.dto;

public class UserTokenStateDTO {

	private UserDTO user;
    private String accessToken;
    private Long expiresIn;
    
    public UserTokenStateDTO() {
        this.accessToken = null;
        this.expiresIn = null;

    }

	public UserTokenStateDTO(UserDTO user, String accessToken, long expiresIn) {
		super();
		this.user = user;
		this.accessToken = accessToken;
		this.expiresIn = expiresIn;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
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
