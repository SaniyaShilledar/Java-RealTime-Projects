package com.sas.vo.constants;

import java.io.Serializable;


public class LoginVO implements Serializable{

	
	private static final long serialVersionUID = -9044910186096573035L;
	
	private String userName;
	private String password;
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
