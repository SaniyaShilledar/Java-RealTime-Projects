package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ChangePwd")
public class ChangePwd extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
			HttpSession session=request.getSession();
			String accno=(String)session.getAttribute("accno");
			String pwd=request.getParameter("npwd");
			Model m=new Model();
			m.setAccno(accno);
			m.setPwd(pwd);
			boolean status=m.changePwd();
			if(status==true) {
				try
				{
					response.sendRedirect("/BankApp/changePwdSuccess.jsp");
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
			else
			{
				try
				{
					response.sendRedirect("/BankApp/changePwdFail.jsp");
				}
			
				catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		}
}

