package com.sas.exceptionclass;

public class SchoolException extends Exception {

	private static final long serialVersionUID = -7069938849663593325L;

	public String name;
	public int number;

	public SchoolException() {

	}

	public SchoolException(String name,Exception e) {
		this.name = name;
	}
	
	public SchoolException(int number,Exception e) {
		this.number = number;
	}
	
	public SchoolException(String name,int number,Exception e) {
		this.number = number;
		this.name=name;
	}


}
