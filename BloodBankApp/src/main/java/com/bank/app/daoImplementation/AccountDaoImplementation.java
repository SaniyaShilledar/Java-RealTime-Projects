package com.bank.app.daoImplementation;

import org.jongo.Jongo;
import org.mindrot.jbcrypt.BCrypt;

import com.bank.app.constants.DB_Name;
import com.bank.app.dao.AccountDao;
import com.bank.app.pojo.Login;
import com.bank.app.pojo.Registration;
import com.bank.app.pojo.Response;
import com.mongodb.WriteResult;

public class AccountDaoImplementation implements AccountDao {

	public Response registrationUser(Registration register) {
		Response response = new Response();
		Registration registeredUser = new Jongo(DB_Name.getMongodbDatabase()).getCollection("registration")
				.findOne("{phNo:#}", register.getPhNo()).as(Registration.class);

		if (registeredUser != null) {
			response.setStatusCode(600);
			response.setStatusMessage("User already Exist");
		}
		else {
			
			new Jongo(DB_Name.getMongodbDatabase()).getCollection("registration").insert(register);
			response.setStatusCode(200);
			response.setStatusMessage("New User Created!");
		}
		return response;
	}

	@Override
	public Response loginCheck(Login login) {
		Response response= new Response();
		Registration user=new Jongo(DB_Name.getMongodbDatabase()).getCollection("registration").findOne("{phNo:#}",login.getPhoneNo()).as(Registration.class);
		if(user!=null) {
		String generatedlogedPasswordHash = BCrypt.hashpw(login.getPassword(), BCrypt.gensalt(12));			
		boolean b=BCrypt.checkpw(user.getPassword(),generatedlogedPasswordHash );
		if (b) {
			response.setStatusCode(200);
			response.setStatusMessage("Successfully logged in!");
		} else {
			response.setStatusCode(600);
			response.setStatusMessage("Error while logging ");
		}
		}
		else {
			response.setStatusCode(600);
			response.setStatusMessage("User Not found");
		}		
		return response;
	}

	@Override
	public Response deleteUser(long phNo) {
		Response response= new Response();
		WriteResult user=new Jongo(DB_Name.getMongodbDatabase()).getCollection("registration").remove("{phNO:#}",phNo);
		
		if (user.getN()>0) {
			response.setStatusCode(200);
			response.setStatusMessage("user deleted");
		} else {
			response.setStatusCode(600);
			response.setStatusMessage("user not found to delete");
		}
		return response;
	}

}
