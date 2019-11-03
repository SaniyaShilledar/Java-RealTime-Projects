package p1;

import java.sql.Connection;
import java.lang.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

public class Model {
	ResultSet rs;
	private int eid;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	private String uid;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	private String pwd;
	private String fullname;
	private String comname;
	private int age;
	private int salary;
	private  String gender;
	private String department ;
	private String state;
	private String city;
	private String address;
    private String skills[];
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	Connection con;
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getComname() {
		return comname;
	}
	public void setComname(String comname) {
		this.comname = comname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String temp;
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	
	public Model()
	{
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("loaded");
			con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system", "system");
			System.out.println("connected");
		}

		catch (SQLException e) {
			System.out.println("Loading failed");
			e.printStackTrace();
		}	
	}
	
	public boolean registerData() {
		try {
		String techskills="";
		for(int i=0;i<skills.length;i++)
		{
			techskills+=","+skills[i];
		}
		PreparedStatement pstmt=con.prepareStatement("INSERT INTO EMPLOYEEDETAIL(FULLNAME,COMNAME,AGE,DEPARTMENT,SALARY,GENDER,STATE,CITY,ADDRESS,SKILLS) VALUES(?,?,?,?,?,?,?,?,?,'"+techskills+"')");
		pstmt.setString(1,fullname);
		pstmt.setString(2,comname);
		pstmt.setInt(3,age);
		pstmt.setString(4,department);
		pstmt.setInt(5,salary);
		pstmt.setString(6,gender);
		pstmt.setString(7,state);
		pstmt.setString(8,city);
		pstmt.setString(9,address);
		
		System.out.println("bbbbbbbbbbbbb");
		int rows=pstmt.executeUpdate();
		System.out.println("cccccccccccc");
		System.out.println(rows);
		if(rows==0) 
		{
			return false;
		}
		else
		{
			return true;

		}

		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return false;
		
	}
	public boolean deleteRow(int n) {
		try {
		Statement statement=con.createStatement();
	
	int cnt=statement.executeUpdate("DELETE FROM EMPLOYEEDETAIL WHERE EID="+n);
	
	if(cnt>0)
	{
	return true;
	}
	else
	{
		return false;
	}
	
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<Model> getEmployees() {
        ArrayList<Model> list = new ArrayList<Model>();
        Statement stmt=null;
        try {
        	/*DriverManager.registerDriver(new OracleDriver());
			System.out.println("loaded");
			con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system", "system");
			System.out.println("connected");*/
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEEDETAIL");
            while (rs.next()) {
            	Model m=new Model();
            	 
                 m.setFullname(rs.getString("fullname"));
                 m.setComname(rs.getString("comname"));
            	 m.setAge( rs.getInt("age"));
            	 m.setDepartment(rs.getString("department"));
            	 m.setSalary(rs.getInt("salary"));
            	 m.setGender(rs.getString("gender"));
            	 m.setState(rs.getString("state"));
            	 m.setCity(rs.getString("city"));
            	 m.setAddress(rs.getString("address"));
            	 m.setTemp(rs.getString("skills"));
            	 m.setEid(rs.getInt("eid"));
            	 
            	 list.add(m);
            	 
            	       	
      }
           	            
          
            
            
        } catch (SQLException ex) {
 
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                
            }
        }
        return list; 
    }
 

	
	
	
	public ArrayList getDetails(int n) throws SQLException  {
	
		
		ArrayList ll=new ArrayList();
			String m=String.valueOf(n);
			PreparedStatement pstmt = con.prepareStatement("select * from EMPLOYEEDETAIL where EID=?");
			pstmt.setString(1,m);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
			ll.add(rs.getString("FULLNAME"));
			ll.add(rs.getString("COMNAME"));
			ll.add(rs.getString("AGE"));
			ll.add(rs.getString("DEPARTMENT"));
			ll.add(rs.getString("SALARY"));
			ll.add(rs.getString("GENDER"));
			ll.add(rs.getString("STATE"));
			System.out.println(state);
			ll.add(rs.getString("CITY"));
			ll.add(rs.getString("ADDRESS"));
			ll.add(rs.getString("SKILLS"));
			}
		  
			for(int i=0;i<ll.size();i++)
			{
				System.out.println(ll.get(i));
			}
			
		
	return ll;
		
		
		
	}
	public boolean updateData(int m) {
		System.out.println(m);
	
		try {
		String techskills="";
		for(int i=0;i<skills.length;i++)
		{
			techskills+=","+skills[i];
		}
		
		PreparedStatement pstmt=con.prepareStatement("UPDATE EMPLOYEEDETAIL SET FULLNAME=?, COMNAME=?, AGE=?, DEPARTMENT=?, SALARY=?, GENDER=?, STATE=?, CITY=?, ADDRESS=?,SKILLS=? WHERE EID='"+m+"' ");
		
		pstmt.setString(1,fullname);
		pstmt.setString(2,comname);
		pstmt.setInt(3,age);
		pstmt.setString(4,department);
		pstmt.setInt(5,salary);
		pstmt.setString(6,gender);
		pstmt.setString(7,state);
		pstmt.setString(8,city);
		pstmt.setString(9,address);
		pstmt.setString(10, techskills);
		
		
		System.out.println("bbbbbbbbbbbbb");
		int rows=pstmt.executeUpdate();
		System.out.println("cccccccccccc");
		System.out.println(rows);
		if(rows==0) 
		{
			return false;
		}
		else
		{
			return true;

		}

	}
	catch(Exception e) {
		e.printStackTrace();
		
	}
	return false;



		
		
		}
	
}
			
	
	
	

