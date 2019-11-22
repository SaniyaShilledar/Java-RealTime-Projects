package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Register")
public class Register extends HttpServlet  {

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
        System.out.println("Parameters");
		String fullname=request.getParameter("fullname");
		System.out.println(fullname);
		
		String comname=request.getParameter("comname");
		System.out.println(comname);
		
		String age=request.getParameter("age");
		System.out.println(age);
		
	    String department=request.getParameter("department");
		System.out.println(department);
		
		
		
	   String salary=request.getParameter("salary");
		System.out.println(salary);
		
		String gender=request.getParameter("gender");
		System.out.println(gender);
		
		String state=request.getParameter("state");
		System.out.println(state);
		
		String city=request.getParameter("city");
		System.out.println(city);
		
		String address=request.getParameter("address");
		System.out.println(address);
		
		String[] skills=request.getParameterValues("skills");
	/*	for(int i=0;i<skills.length;i++)
		{
		System.out.println(skills[i]);
		}*/
		
		Model m=new Model();
		m.setFullname(fullname);
		m.setComname(comname);
		m.setAge(Integer.valueOf(age));
		m.setDepartment(department);
		m.setSalary(Integer.valueOf(salary));
		m.setGender(gender);
		m.setState(state);
		m.setCity(city);
		m.setAddress(address);
		System.out.println("cccccccccccccccccccccccc");
		m.setSkills(skills);
		boolean status=m.registerData();
		if(status==true)
		{
			response.sendRedirect("/LoginPage/employeeRecord.jsp");
			//RequestDispatcher rd = request.getRequestDispatcher("/FetchDisplay");  
			//rd.forward(request, response);
			
			}
		else
		{
			response.sendRedirect("/LoginPage/regFail.jsp");
	     }
		
		
	}
}
