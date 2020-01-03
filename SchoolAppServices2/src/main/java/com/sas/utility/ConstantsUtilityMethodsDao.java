package com.sas.utility;

import java.util.List;

import com.sas.exceptionclass.SchoolException;
import com.sas.general.vo.RoleIdsVo;


public interface ConstantsUtilityMethodsDao {

	int autoIncrease(String name)throws SchoolException ;

	List<RoleIdsVo> getRoleIds(int roleId)throws SchoolException;

}
