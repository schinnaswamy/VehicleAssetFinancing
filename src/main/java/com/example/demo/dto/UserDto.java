package com.example.demo.dto;

public class UserDto {
	//Integer userId;
	String userName;
	String password;

	public UserDto(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public UserDto() {
	}

	/*public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}*/

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
}
