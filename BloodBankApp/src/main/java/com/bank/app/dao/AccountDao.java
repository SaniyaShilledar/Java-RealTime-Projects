package com.bank.app.dao;

import com.bank.app.pojo.*;

public interface AccountDao {

	Response registrationUser(Registration registration);
	Response loginCheck(Login login);
	Response deleteUser(long phNo);
	
}
