package com.bank.app.services;

import com.bank.app.dao.AccountDao;
import com.bank.app.daoImplementation.AccountDaoImplementation;
import com.bank.app.pojo.Login;
import com.bank.app.pojo.Registration;
import com.bank.app.pojo.Response;

public class AccountService {

	AccountDao accountdao= new AccountDaoImplementation();
	
	public Response registrationUser(Registration registration)
	{
		return accountdao.registrationUser(registration);
	}
	
	public Response checkLogin(Login login) {
		return accountdao.loginCheck(login);
	}
	
	public Response deleteUser(long phNo) {
		return accountdao.deleteUser(phNo);
	}
}

