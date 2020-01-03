package com.sas.superAdmin;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sas.exceptionclass.SchoolException;
import com.sas.response.ResultResponse;
import com.sas.response.StatusCodeResponse;
import com.sas.response.StatusMessageResponse;
import com.sas.vo.constants.AddSchoolVo;
import com.sas.vo.constants.LoginVO;

@RestController
@RequestMapping("/account")
public class SuperAdminController {
	
	private static final Logger logger = Logger.getLogger(SuperAdminController.class);
	
	@Autowired()
	SuperAdminService superAdminService;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResultResponse<LoginVO> login(@RequestBody LoginVO loginvo)throws SchoolException{
		ResultResponse<LoginVO>	resultResponse=new ResultResponse<>();
		
		try {
			resultResponse=superAdminService.login(loginvo);
			logger.info("Login sucssfully in controller class");
		}catch(SchoolException e) {
			resultResponse.setStatusCode(StatusCodeResponse.status_Code_Server);
			resultResponse.setStatusMessage(StatusMessageResponse.status_Message_Server);
			logger.debug("Exception occured will Student login in conroller class ::", e);
		}
		
		return resultResponse;
	}
	
	@RequestMapping(value = "/addschool", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResultResponse<Void> addSchool(@RequestBody AddSchoolVo addSchoolVo){
		ResultResponse<Void>	resultResponse=null;
		try {
			resultResponse=superAdminService.addSchool(addSchoolVo);
			logger.info("Added sucssfully in controller class");
		}catch(Exception e) {
			resultResponse.setStatusCode(StatusCodeResponse.status_Code_Server);
			resultResponse.setStatusMessage(StatusMessageResponse.status_Message_Server);
			logger.debug("Exception occured will Student login in conroller class ::", e);
		}
		
		return resultResponse;
	}
}
