package com.sas.mongo.constants;

import java.util.ArrayList;
import java.util.List;
import com.mongodb.ServerAddress;

public class Constants {

	private static final String MONGODB_HOST = "cluster0-shard-00-00-rl5cc.mongodb.net";
	/*private static final String MONGO_SERVER_HOST_1 = "democluster-shard-00-00-fsnns.mongodb.net";
	private static final String MONGO_SERVER_HOST_2 = "democluster-shard-00-01-fsnns.mongodb.net";
	private static final String MONGO_SERVER_HOST_3 = "democluster-shard-00-02-fsnns.mongodb.net";*/
	private static final int MONGODB_PORT = 27017;
	private static final String MONGODB_DATABASE = "schoolbase";
	/*private static final String MONGO_SERVER_USERNAME = "Venkatesh";
	private static final String MONGO_SERVER_PASSWORD = "schoolproject";*/
	/*private static final String HSIGNZ_DB = "HSignzDB";
	private static final String POZ_SERVER_URL = "http://demopoz.ap-south-1.elasticbeanstalk.com/";
	private static final String CONQUEST_SERVER_URL = "http://democonquest.ap-south-1.elasticbeanstalk.com/";

	private static final String AWS_ACCESS_KEY_ID = "AWS_ACCESS_KEY_ID";
	private static final String AWS_SECRET_ACCESS_KEY = "AWS_SECRET_ACCESS_KEY";

	private static final String AWS_S3_BUCKET_NAME = "healthsignzdemo";
	private static final String AWS_S3_BUCKET_URL = "https://s3.ap-south-1.amazonaws.com/";
	private static final String AWS_REGION = "ap-south-1";

	private static final String AWS_COGNITO_POOL_IDENTITY = "ap-northeast-1:82ee8b0b-a4b1-4f24-a817-fe44c6393a92";
	private static final String AWS_COGNITO_DEVELOPER_IDENTITY = "cognito-identity.amazonaws.com";
	private static final String AWS_COGNITO_REGION = "ap-northeast-1";
	private static final String AWS_COGNITO_AUTH_ROLE_ARN = "arn:aws:iam::074093816040:role/Cognito_testAuth_Role";

	private static final String SMS_API_KEY = "A4c72da50fe7abc9cb1e41f4bf265b932";
	private static final String SMS_SENDER = "HSignz";*/

	public List<ServerAddress> getMongoServerAddresses() {
		List<ServerAddress> serverAddressList = new ArrayList<>();
		serverAddressList.add(new ServerAddress(MONGODB_HOST, MONGODB_PORT));
		/*serverAddressList.add(new ServerAddress(MONGO_SERVER_HOST_2, MONGODB_PORT));
		serverAddressList.add(new ServerAddress(MONGO_SERVER_HOST_3, MONGODB_PORT));*/
		return serverAddressList;
	}
/*	public List<MongoCredential> getMongoCredentials() {
		System.out.println("Mongo credantial method in mongodb");
		List<MongoCredential> credentials = new ArrayList<>();
		System.out.println("Mongo server username is::"+MONGO_SERVER_USERNAME);
		String userName = getEnvironmentVariable(MONGO_SERVER_USERNAME)MONGO_SERVER_USERNAME;
		String password = getEnvironmentVariable(MONGO_SERVER_PASSWORD)MONGO_SERVER_PASSWORD;
		System.out.println(userName);
		System.out.println(password);
		if (userName != null && password != null) {
			System.out.println("user name and password is not null");
			credentials.add(MongoCredential.createCredential(userName, "schoolbase", password.toCharArray()));
		}
		return credentials;
	}*/
	public String getDBName() {
		System.out.println("Data base name is ::"+MONGODB_DATABASE);
		return MONGODB_DATABASE;
	}

	/*public String getAWSRegion() {
		return AWS_REGION;
	}

	public String getAWSSecret() {
		return getEnvironmentVariable(AWS_SECRET_ACCESS_KEY);
	}

	public String getAWSAccessKey() {
		return getEnvironmentVariable(AWS_ACCESS_KEY_ID);
	}

	public String getAWSBucketName() {
		return AWS_S3_BUCKET_NAME;
	}

	public String getAWSBucketURL() {
		return AWS_S3_BUCKET_URL;
	}

	public String getPOZServerURL() {
		return POZ_SERVER_URL;
	}

	public String getHsignzServerURL() {
		return CONQUEST_SERVER_URL;
	}

	public String getSMSAPIKey() {
		return SMS_API_KEY;
	}

	public String getSMSSender() {
		return SMS_SENDER;
	}

	public String getAWSCognitoPoolIdentity() {
		return AWS_COGNITO_POOL_IDENTITY;
	}

	public String getAWSCognitoDeveloperIdentity() {
		return AWS_COGNITO_DEVELOPER_IDENTITY;
	}

	public String getAWSCognitoRegion() {
		return AWS_COGNITO_REGION;
	}

	public String getAWSCognitoAuthRole() {
		return AWS_COGNITO_AUTH_ROLE_ARN;
	}
*/
	private String getEnvironmentVariable(String envVarKey) {
		//System.out.println("envVarKey::"+envVarKey);
		if (System.getenv(envVarKey) != null) {
			return System.getenv(envVarKey);
		} else if (System.getProperty(envVarKey) != null) {
			return System.getProperty(envVarKey);
		} else {
			return null;
		}
	}

	
}


