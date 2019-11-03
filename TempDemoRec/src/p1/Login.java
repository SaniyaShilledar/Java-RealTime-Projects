package p1;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("uid");
		String pwd=request.getParameter("pwd");
		HttpSession session=request.getSession();
		if(uid.equals("admin")&&pwd.equals("admin"))
		{
			/* EmployeeBean eb = new EmployeeBean();
             ArrayList<Model> list = eb.getEmployees();
         request.setAttribute("list", list);*/
		response.sendRedirect("/TempDemoRec/employeeRecord.jsp");

		
	}
		
		else
		{
			response.sendRedirect("/TempDemoRec/loginfailed.jsp");
			
		}
		
	}	
}


