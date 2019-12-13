package com.sas.superAdmin;

import com.sas.exceptionclass.SchoolException;
import com.sas.response.ResultResponse;
import com.sas.vo.constants.AddSchoolVo;
import com.sas.vo.constants.LoginVO;

public interface SuperAdminDao {

	ResultResponse<LoginVO> login(LoginVO loginvo)throws SchoolException;

	int addSchool(AddSchoolVo addSchoolVo)throws SchoolException;

}
