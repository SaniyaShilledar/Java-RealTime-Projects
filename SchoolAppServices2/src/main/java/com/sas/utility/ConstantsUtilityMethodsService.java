package com.sas.utility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.exceptionclass.SchoolException;
import com.sas.general.vo.RoleIdsVo;
import com.sas.response.ResultResponse;
import com.sas.response.StatusCodeResponse;
import com.sas.response.StatusMessageResponse;

@Service("constantsutilitymethodsservice")
public class ConstantsUtilityMethodsService {

	@Autowired
	ConstantsUtilityMethodsDao constantsUtilityMethodsDao;
	
	public ResultResponse<Void> autoIncrease(String name) throws SchoolException {
		ResultResponse<Void> resultResponse=new ResultResponse<>();
		
	int n=	constantsUtilityMethodsDao.autoIncrease(name);
	if(n>0) {
		resultResponse.setStatusCode(StatusCodeResponse.status_Code_Update);
		resultResponse.setStatusMessage(StatusMessageResponse.status_Message_Update);
	}else {
		resultResponse.setStatusCode(StatusCodeResponse.status_Code_Server);
		resultResponse.setStatusMessage(StatusMessageResponse.status_Message_Server);
	}
		return resultResponse;
	}

	public ResultResponse<List<RoleIdsVo>> getRoleIds(int roleId)throws SchoolException {
		ResultResponse<List<RoleIdsVo>> resultResponse=new ResultResponse<>();
		System.out.println("====>>>>>Servic eclasss");
		List<RoleIdsVo> roleIdsVosList=null;
		roleIdsVosList=constantsUtilityMethodsDao.getRoleIds(roleId);
		
		if(roleIdsVosList !=null) {
			System.out.println("Role Ids List is not nulll");
			resultResponse.setStatusCode(StatusCodeResponse.status_Code_OK);
			resultResponse.setStatusMessage(StatusMessageResponse.status_Message_CREATED);
			resultResponse.setData(roleIdsVosList);
		}else {
			System.out.println("Role Ids List is  nulll");
			resultResponse.setStatusCode(StatusCodeResponse.status_Code_Server);
			resultResponse.setStatusMessage(StatusMessageResponse.status_Message_Server);
		}
		return resultResponse;
	}

	
	
}
