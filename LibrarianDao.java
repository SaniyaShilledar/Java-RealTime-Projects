package p1;

import java.sql.*;

public class LibrarianDao {

	public static int save(String name, String password, String email, String address, String city, String contact) {

	
		int status=0;
		try {
		
			
			 
	     Connection con=DBConn.getConnection();
	     PreparedStatement ps=con.prepareStatement("select count(name) from librarian");
		 ResultSet rs1=ps.executeQuery();
	     String n="";
		 if(rs1.next()) {
			n=rs1.getString("count(name)");
			}
		 int lab_id=(n.charAt(0)-48)+1;
		 
	
             con.close();
             Thread.sleep(1000);
             
            Connection con1=DBConn.getConnection();
            PreparedStatement ps1=con1.prepareStatement("insert into librarian(name,password,email,address,city,contact,id) values(?,?,?,?,?,?,?)");
			ps1.setString(1,name);
			ps1.setString(2,password);
			ps1.setString(3,email);
			ps1.setString(4,address);
			ps1.setString(5,city);
			ps1.setString(6,contact);
			ps1.setInt(7,lab_id);
			status=ps1.executeUpdate();
			
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static int delete(int id) {
		
		int status=0;
		try{
			Connection con=DBConn.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from librarian where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
			}
		return status;
	}

	public static boolean validate(String name, String password) {
		// TODO Auto-generated method stub
		boolean status=false;
		try{
			Connection con=DBConn.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from librarian where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e)
		{
			System.out.println(e);
			}
		return status;
	}

	}


