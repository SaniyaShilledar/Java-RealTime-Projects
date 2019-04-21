package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDao {

	
	public static int save(String call_no,String name,String author,String publisher,int quantity){
		int status=0;
		try{
			
			Connection con=DBConn.getConnection();
			java.util.Date date=new java.util.Date();
			java.sql.Date sqldate=new java.sql.Date(date.getTime());
			
			PreparedStatement ps=con.prepareStatement("insert into books(callno,name,author,publisher,quantity,added_date) values(?,?,?,?,?,?)");
			ps.setString(1,call_no);
			ps.setString(2,name);
			ps.setString(3,author);
			ps.setString(4,publisher);
			ps.setInt(5,quantity);
			ps.setDate(6, sqldate);
			
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e){System.out.println(e);
		}
		return status;
	}

	}


