package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import oracle.jdbc.driver.OracleDriver;

public class EmployeeBean {
	  /*  private static final String JDBC_DRIVER = "oracle.jdbc.Driver.OracleDriver";
	    private static final String DATABASE_URL = "jdbc:oracle:thin:@//localhost:1521/XE";
	    private static final String USERNAME = "system";
	    private static final String PASSWORD = "system";*/
	 
	 /*   public void addNew(Employee e) {
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        try {
	            Class.forName(JDBC_DRIVER);
	            con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	            pstmt = con.prepareStatement("INSERT INTO emp1(empId,empName,phone,email,salary,desig) VALUES(?,?,?,?,?,?)");
	            pstmt.setInt(1, e.getEmpId());
	            pstmt.setString(2, e.getEmpName());
	            pstmt.setString(3, e.getPhone());
	            pstmt.setString(4, e.getEmail());
	            pstmt.setFloat(5, e.getSalary());
	            pstmt.setString(6, e.getDesignation());
	            pstmt.execute();
	        } catch (SQLException | ClassNotFoundException ex) {
	 
	        } finally {
	            try {
	                if (pstmt != null) {
	                    pstmt.close();
	                }
	                if (con != null) {
	                    con.close();
	                }
	            } catch (SQLException ex) {
	                Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	 
	    public void delete(int id) {
	        Connection con = null;
	        Statement stmt = null;
	        try {
	            Class.forName(JDBC_DRIVER);
	            con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	            stmt = con.createStatement();
	            stmt.execute("DELETE FROM emp WHERE empId=" + String.valueOf(id));
	        } catch (SQLException | ClassNotFoundException ex) {
	 
	        } finally {
	            try {
	                if (stmt != null) {
	                    stmt.close();
	                }
	                if (con != null) {
	                    con.close();
	                }
	            } catch (SQLException ex) {
	                Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	 
	    public void update(Employee e) {
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        try {
	            Class.forName(JDBC_DRIVER);
	            con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	            pstmt = con.prepareStatement("UPDATE emp1 SET empName=?, phone=?, email=?, salary=?, desig=? WHERE empId=?");
	            pstmt.setString(1, e.getEmpName());
	            pstmt.setString(2, e.getPhone());
	            pstmt.setString(3, e.getEmail());
	            pstmt.setFloat(4, e.getSalary());
	            pstmt.setString(5, e.getDesignation());
	            pstmt.setInt(6, e.getEmpId());
	            pstmt.executeUpdate();
	        } catch (SQLException | ClassNotFoundException ex) {
	 
	        } finally {
	            try {
	                if (pstmt != null) {
	                    pstmt.close();
	                }
	                if (con != null) {
	                    con.close();
	                }
	            } catch (SQLException ex) {
	                Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	 
	    public Employee getEmployee(int id) {
	        Employee emp = null;
	        Connection con = null;
	        Statement stmt = null;
	        try {
	            Class.forName(JDBC_DRIVER);
	            con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	            stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM emp1 WHERE empId=" + id);
	            if (rs.next()) {
	                emp = new Employee();
	                emp.setEmpId(rs.getInt(1));
	                emp.setEmpName(rs.getString(2));
	                emp.setPhone(rs.getString(3));
	                emp.setEmail(rs.getString(4));
	                emp.setSalary(rs.getFloat(5));
	                emp.setDesignation(rs.getString(6));
	            }
	        } catch (SQLException | ClassNotFoundException ex) {
	 
	        } finally {
	            try {
	                if (stmt != null) {
	                    stmt.close();
	                }
	                if (con != null) {
	                    con.close();
	                }
	            } catch (SQLException ex) {
	                Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	        return emp;
	    }
	 */
	    public ArrayList<Model> getEmployees() {
	        ArrayList<Model> list = new ArrayList<Model>();
	        Connection con = null;
	        Statement stmt = null;
	        try {
	        /*	DriverManager.registerDriver(new OracleDriver());
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
	 
	}

