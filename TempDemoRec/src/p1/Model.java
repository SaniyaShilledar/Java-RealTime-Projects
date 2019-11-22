package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

public class Model {
	Connection con;
	ResultSet rs;
	private String uid;
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
	private List l;
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
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	private String temp;
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	/*public Model()
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
	public ResultSet fetchData() {
		// TODO Auto-generated method stub
		try {
			
		Statement statement = con.createStatement() ;
        ResultSet rs = statement.executeQuery("select * from EMPLOYEEDETAIL") ;
        
        
      }
		catch(Exception e)
		{
			e.printStackTrace();
		}
        
		return rs;
	
	
	
	}*/
	
	}
