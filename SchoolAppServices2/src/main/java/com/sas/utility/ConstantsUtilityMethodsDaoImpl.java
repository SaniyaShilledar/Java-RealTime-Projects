package com.sas.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jongo.Jongo;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;
import com.sas.exceptionclass.SchoolException;
import com.sas.general.vo.RoleIdsVo;
import com.sas.mongo.constants.MongoDBUtil;
import com.sas.mongo.constants.MongoDbConstantsCollections;

@Repository("constantsUtilityMethodsDao")
public class ConstantsUtilityMethodsDaoImpl implements ConstantsUtilityMethodsDao {

	@Override
	public int autoIncrease(String name)throws SchoolException {
		WriteResult writeResult = null;
		try {
			writeResult = new Jongo(MongoDBUtil.getDB()).getCollection(MongoDbConstantsCollections.CN_COUNTERS).update("{ _id:# }",name).upsert()
					.with("{ $inc: { sq: 1} }");
			
		} catch (Exception e) {
			throw new SchoolException("Exception Occured will autoincrease",e);
		}
		return writeResult.getN();
	}

	@Override
	public List<RoleIdsVo> getRoleIds(int roleId) throws SchoolException {
		Iterator<RoleIdsVo> itr=null;
		List<RoleIdsVo> list=new ArrayList<>();
		try {
		 itr=	new Jongo(MongoDBUtil.getDB()).getCollection(MongoDbConstantsCollections.CN_ROLES).aggregate("{$match:{'roleId':{ $gte: #}}}",roleId)
			.as(RoleIdsVo.class).iterator();
		 while(itr.hasNext()) {
			list.add(itr.next()) ;
		 }
		}catch (Exception e) {
			throw new SchoolException("Exception Occured will Getting roleids ",e);
		}
		return list;
	}

}
