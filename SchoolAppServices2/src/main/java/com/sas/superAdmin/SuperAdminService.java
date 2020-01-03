package com.sas.superAdmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.exceptionclass.SchoolException;
import com.sas.response.ResultResponse;
import com.sas.response.StatusCodeResponse;
import com.sas.response.StatusMessageResponse;
import com.sas.vo.constants.AddSchoolVo;
import com.sas.vo.constants.LoginVO;


@Service("superAdminService")
public class SuperAdminService {

	@Autowired
	SuperAdminDao superAdminDao;

	
	public ResultResponse<LoginVO> login(LoginVO loginvo)throws SchoolException {
		ResultResponse<LoginVO> resultResponse = new ResultResponse<LoginVO>();
		resultResponse =superAdminDao.login(loginvo);
		return resultResponse;
	}


	public ResultResponse<Void> addSchool(AddSchoolVo addSchoolVo) throws SchoolException{
		ResultResponse<Void> resultResponse=new ResultResponse<>();
  int result=superAdminDao.addSchool(addSchoolVo);
  
  if(result >0) {
	  resultResponse.setStatusCode(StatusCodeResponse.status_Code_OK);
	  resultResponse.setStatusMessage(StatusMessageResponse.status_Message_CREATED);
  }else {
	  resultResponse.setStatusCode(StatusCodeResponse.status_Code_Server);
	  resultResponse.setStatusMessage(StatusMessageResponse.status_Message_Server);
  }
		return resultResponse;
	}
	
}
