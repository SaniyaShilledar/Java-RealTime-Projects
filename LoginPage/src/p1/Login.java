package p1;

import java.io.IOException;

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
		if(uid.equals("admin")&&pwd.equals("admin"))
		{
		response.sendRedirect("/LoginPage/employeeRecord.jsp");
	
		}
		else
		{
			response.sendRedirect("/LoginPage/loginfailed.jsp");
			
		}
	}


}
