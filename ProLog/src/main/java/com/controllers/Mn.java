package com.controllers;

import java.util.Iterator;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Mn {

	DBCollection col;
	MongoClient mc;
	
	Mn(){
		mc=new MongoClient("localhost",27017);
		@SuppressWarnings("deprecation")
		DB db=mc.getDB("login");
		col=db.getCollection("login");
	}
	
	public Boolean fetch(String name,String pass) {

		BasicDBObject obj=new BasicDBObject();
		obj.put("username",name);
		obj.put("passcord",pass);
		
		DBCursor cur=col.find(obj);
		Iterator<DBObject> it=cur.iterator();
		while (it.hasNext()) {
			DBObject dbObject = it.next();
			if(dbObject.get("username").equals(name)&& dbObject.get("passcord").equals(pass))
				return true;
		}		
		return false;
	}
}
