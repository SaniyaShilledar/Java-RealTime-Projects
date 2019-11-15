package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class Model {
	private String name;
	private String accno;
	private String balance;
	private String cid;
	private String pwd;
	private String email;
	Connection con;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Model()
	{
		try {
			DriverManager.registerDriver(new OracleDriver());
			con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system", "system");
		}

		catch (SQLException e) {
			System.out.println("Loading failed");
			e.printStackTrace();
		}	
	}

	public boolean logic() 
	{
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from BANK where CID=? and PWD=?");
			pstmt.setString(1, cid);
			pstmt.setString(2, pwd);
			ResultSet res=pstmt.executeQuery();
			while(res.next()==true) 
			{
				name=res.getString("NAME");
				accno=res.getString("ACCNO");
				return true;
			}
		}

		catch (SQLException e)
		{
			System.out.println("logic return failed");
			e.printStackTrace();
		}	
		return false;
	}
	public boolean checkBalance() {

		try {
			PreparedStatement pstmt = con.prepareStatement("select * from BANK where ACCNO=?"); 
			pstmt.setString(1,accno);
			ResultSet res=pstmt.executeQuery();
			while(res.next()==true) 
			{
				balance=res.getString("BALANCE");

				System.out.println(balance);
				return true;
			}
		}
		catch (SQLException e) {
			System.out.println("checking failed");
			e.printStackTrace();
		}
		return false;
	}
	public boolean changePwd() {
		try {
			PreparedStatement pstmt = con.prepareStatement("UPDATE BANK SET PWD=? WHERE ACCNO=?"); 
			pstmt.setString(1,pwd);
			pstmt.setString(2,accno);
			int  rows=pstmt.executeUpdate();
			if(rows==0) 
			{
				return false;
			}
			else
			{
				return true;

			}
		}

		catch (SQLException e) {
			System.out.println("checking failed");
			e.printStackTrace();
		}
		return false;


	}


	public boolean transfer(String tamt) {
		try {
			PreparedStatement pstmt = con.prepareStatement("update BANK set BALANCE=BALANCE-? where ACCNO=?"); 
			pstmt.setString(1,tamt);
			pstmt.setString(2,accno);
			int  rows=pstmt.executeUpdate();

			pstmt=con.prepareStatement("insert into BANK_STATEMENT1 values(?,?)");
			pstmt.setString(1, accno);
			pstmt.setString(2, tamt);
			pstmt.executeUpdate();

			if(rows==0) 
			{
				return false;
			}
			else
			{
				return true;

			}
		}

		catch (SQLException e) {
			System.out.println("checking failed");
			e.printStackTrace();
		}
		return false;

	}

	public ArrayList getStatement() {
		
		ArrayList al=new ArrayList();
		try {

			PreparedStatement pstmt = con.prepareStatement("select * from BANK_STATEMENT1 where ACCNO=?"); 
			pstmt.setString(1,accno);
			ResultSet res=pstmt.executeQuery();
			al=new ArrayList();
			while(res.next()==true) 
			{
				al.add(res.getString(2));
			}
			
		}

		catch (SQLException e) {
			System.out.println("checking failed");
			e.printStackTrace();
		}

		return al;

	}




}
