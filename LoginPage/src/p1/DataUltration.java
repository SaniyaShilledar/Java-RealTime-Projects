package p1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DataUltration")
public class DataUltration extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
			String action=request.getParameter("action");
			String eid=request.getParameter("eid");
			int n=Integer.valueOf(eid);
			System.out.println(n);
	       if("Delete".equals(action))
			{
	    	   Model m=new Model();
	    	   boolean b=m.deleteRow(n);
	    	   if(b==true)
	    	   {
	    		   response.sendRedirect("/LoginPage/employeeRecord.jsp");
	    	   }
	    	   else
	    	   {
	    		   response.sendRedirect("/LoginPage/rowDelete.jsp"); 
	    	   }
	    	  
	    	}
			else if("Edit".equals(action))
			{
				Model m=new Model();
			
				ArrayList dataList=new ArrayList();
				HttpSession session=request.getSession();
					for(int i=0;i<dataList.size();i++)
					{
						System.out.println(dataList.get(i));
					}
					try {
						dataList = m.getDetails(n);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(dataList.isEmpty())
					{
						response.sendRedirect("/LoginPage/rowUpdate.jsp");
					}
					else
					{
				session.setAttribute("dataList", dataList);
				session.setAttribute("eid",eid);
			    response.sendRedirect("/LoginPage/editPage.jsp");
				
			         }
					
			
			}
	     
			
	       
		}
	}
	

}
