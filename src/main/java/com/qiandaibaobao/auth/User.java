package com.qiandaibaobao.auth;

public class User {
	private String userName;
	private String passwd;
	public User() {
	}
	public User(String userName, String passwd){
		this.userName = userName;
		this.passwd = passwd;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	@Override
	public String toString() {
		return String.format("User: %s,%s", this.userName,this.passwd);
	}
	

}
