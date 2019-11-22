package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class DBConn {
	public static Connection getConnection(){
		Connection con=null;
		
		try 
		{
			DriverManager.registerDriver(new OracleDriver());
			con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "system");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	


	}
}

