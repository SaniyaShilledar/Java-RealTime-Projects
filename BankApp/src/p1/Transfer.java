package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			{
				String tamt=request.getParameter("tamt");
				HttpSession session=request.getSession();
				String accno=(String)session.getAttribute("accno");
			Model m=new Model();
           m.setAccno(accno);
           
            boolean status=m.transfer(tamt);
	       if(status==true)
	       {
			
			response.sendRedirect("/BankApp/transfersuccess.jsp");
			}
			else
			{
				response.sendRedirect("/BankApp/transferfailed.jsp");
   }
			}
		}
}
