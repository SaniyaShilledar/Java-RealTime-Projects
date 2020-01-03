package com.bank.app.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.app.pojo.Login;
import com.bank.app.pojo.Registration;
import com.bank.app.pojo.Response;
import com.bank.app.services.AccountService;

@RestController
@RequestMapping("/account")
public class UserController {

	AccountService acctService=new AccountService();
	
	@RequestMapping(value="/registration",method = RequestMethod.POST)
	public Response registrationUser(@RequestBody Registration registration) {
		Response response=new Response();
		try {
			response=acctService.registrationUser(registration);
		}catch (Exception e) {
			response.setStatusCode(600);
			response.setStatusMessage("Error in registration");
		}
		return response;
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public Response login(@RequestBody Login login) {
	Response response=new Response();
	
	try {
	response=acctService.checkLogin(login);
	
	}catch (Exception e) {
		response.setStatusCode(600);
		response.setStatusMessage("Error in logging");
	}
		return response;
	}
	
	public Response deleteUser(@RequestBody long phNo) {
		Response response=new Response();
	try {
		response=acctService.deleteUser(phNo);
		
	}catch (Exception e) {
		response.setStatusCode(600);
		response.setStatusMessage("Error in Deleting User");
	}
		return null;
	}
	
}
