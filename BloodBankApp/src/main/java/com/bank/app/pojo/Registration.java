package com.bank.app.pojo;

import javax.validation.constraints.Size;

public class Registration {

	private long id;	
	private String firstName;
	private String bloodGroup;
	private long phNo;
	@Size(min=4)
	private String password;		

	public  String getFirstName() {
		return firstName;
	}

	public  void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public  String getBloodGroup() {
		return bloodGroup;
	}

	public  void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public long getPhNo() {
		return phNo;
	}

	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}

	public  String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
