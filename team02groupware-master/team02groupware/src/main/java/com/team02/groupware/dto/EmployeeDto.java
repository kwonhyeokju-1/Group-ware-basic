package com.team02.groupware.dto;

public class EmployeeDto {
	
	private String userId;
	private String userPw;
	private String userLevel;
	private String userName;
	private String userNickName;
	private String userCode;
	
	
	
	
	@Override
	public String toString() {
		return "EmployeeDto [userId=" + userId + ", userPw=" + userPw + ", userLevel=" + userLevel + ", userName="
				+ userName + ", userNickName=" + userNickName + ", userCode=" + userCode + "]";
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	
	

}
