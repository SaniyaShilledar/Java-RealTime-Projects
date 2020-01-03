package com.sas.utility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sas.exceptionclass.SchoolException;
import com.sas.general.vo.RoleIdsVo;
import com.sas.response.ResultResponse;

@RequestMapping("/constants")
@RestController
public class ConstantsUtilityMethodsController {

	@Autowired
	ConstantsUtilityMethodsService constantsutilitymethodsservice;
	
@RequestMapping(value="/sqincrease", method = RequestMethod.GET, headers = "Accept=application/json")	
public ResultResponse<Void> autoIncrease(@RequestParam String name)throws SchoolException 
{
	ResultResponse<Void> resultResponse=new ResultResponse<>();
	try {
	resultResponse=constantsutilitymethodsservice.autoIncrease(name);
	}catch(Exception e) {
		throw new SchoolException("Exception occured will Auto Increasing", e);
	}
	return resultResponse;
}

@RequestMapping(value="/roleids", method = RequestMethod.GET, headers = "Accept=application/json")	
public ResultResponse<List<RoleIdsVo>> getRoleIds(@RequestParam int roleId)throws SchoolException 
{
	System.out.println("++++>>>Controller class");
	ResultResponse<List<RoleIdsVo>> resultResponse=new ResultResponse<>();
	try {
	resultResponse=constantsutilitymethodsservice.getRoleIds(roleId);
	}catch(Exception e) {
		throw new SchoolException("Exception occured will Getting RoleIds", e);
	}
	return resultResponse;
}
	
}
