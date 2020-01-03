package com.bank.app.pojo;

import java.util.Date;

public class Transaction {

	String transactionUserName;
	int amount;
	String bloodgroup;
	public String getTransactionUserName() {
		return transactionUserName;
	}
	public void setTransactionUserName(String transactionUserName) {
		this.transactionUserName = transactionUserName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	
	@Override
	public String toString() {
		return "->"+getTransactionUserName()+" paid "+getAmount()+" for "+getBloodgroup();
	}
}
