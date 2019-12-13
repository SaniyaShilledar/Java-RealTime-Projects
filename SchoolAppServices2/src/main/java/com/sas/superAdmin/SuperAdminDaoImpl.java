package com.sas.superAdmin;

import org.jongo.Jongo;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;
import com.sas.exceptionclass.SchoolException;
import com.sas.mongo.constants.MongoDBUtil;
import com.sas.mongo.constants.MongoDbConstantsCollections;
import com.sas.response.ResultResponse;
import com.sas.response.StatusCodeResponse;
import com.sas.response.StatusMessageResponse;
import com.sas.vo.constants.AddSchoolVo;
import com.sas.vo.constants.LoginVO;

@Repository("superAdminDao")
public class SuperAdminDaoImpl implements SuperAdminDao {

	
	@Override
	public ResultResponse<LoginVO> login(LoginVO loginvo) throws SchoolException {

		ResultResponse<LoginVO> resultResponse = new ResultResponse<>();
		LoginVO loginVO2 = new LoginVO();

		try {
			loginVO2 = new Jongo(MongoDBUtil.getDB()).getCollection(MongoDbConstantsCollections.CN_LOGINCREDENTIALS)
					.findOne("{userName:#,password:#}", loginvo.getUserName(), loginvo.getPassword()).as(LoginVO.class);

			if (loginVO2 != null) {
				resultResponse.setStatusCode(StatusCodeResponse.status_Code_OK);
				resultResponse.setStatusMessage(StatusMessageResponse.status_Message_CREATED);
				resultResponse.setData(loginVO2);
			} else {
				resultResponse.setStatusCode(StatusCodeResponse.status_Code_Server);
				resultResponse.setStatusMessage(StatusMessageResponse.status_Message_Email);
			}
		} catch (Exception e) {
			resultResponse.setStatusCode(StatusCodeResponse.status_Code_Server);
			resultResponse.setStatusMessage(StatusMessageResponse.status_Message_Server);
			throw new SchoolException("Exception  Occured will login ", e);
		}
		return resultResponse;
	}

	@Override
	public int addSchool(AddSchoolVo addSchoolVo) throws SchoolException {
		ResultResponse<Void> resultResponse = new ResultResponse<>();
		WriteResult writeResult = null;
		//String schoolId1="schoolId"; 
		try {
			writeResult=new Jongo(MongoDBUtil.getDB()).getCollection(MongoDbConstantsCollections.CN_SCHOOLSLIST).insert(addSchoolVo);
			/*ConstantsUtilityMethodsService constantsUtilityMethodsController=new ConstantsUtilityMethodsService();
			resultResponse=	constantsUtilityMethodsController.autoIncrease(schoolId1);*/
			System.out.println("How many documents are inserted::" + writeResult.getN());
		} catch (Exception e) {
			resultResponse.setStatusCode(StatusCodeResponse.status_Code_Server);
			resultResponse.setStatusMessage(StatusMessageResponse.status_Message_Server);
			throw new SchoolException("Exception  Occured will Adding schools ", e);
		}
		return writeResult.getN();
	}

}
