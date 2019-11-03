<%@ page language="java" contentType="text/html; charset=ISO-8859-8"
    pageEncoding="ISO-8859-8"%>
     <%@ page import="java.sql.ResultSet,java.util.*" %>
     <%@page import="p1.EmployeeBean"%>
<%@page import="p1.Model"%>
<%@page import="java.util.List"%>
     
   <!DOCTYPE html>
<html lang="en">
<head>
<title>Insert title here</title>
<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>
<% ResultSet rs;%>
<h3 align="center">EMPLOYEE RECORD</h3>
<br></br>
<a href="employeeRegistration.jsp"><button type="button" style='margin-left:250px' align="center">Add</button></a>
 <a href="Back"><button type="button" style='margin-left:800px' >Back</button></a>
<br></br>

<form action="" >
        <TABLE border="2" align="center">
     
            <TR>
            	<TH>Full Name</TH>
                <TH>Company Name</TH>
                <TH>Age</TH>
                <TH>Department</TH>
                <TH>Salary</TH>
                <TH>Gender</TH>
                <TH>State</TH>
                <TH>City</TH>
                <TH>Address</TH>
                <TH>Skills</TH>
             </TR>
              <%
                        EmployeeBean eb = new EmployeeBean();
                        List<Model> list = eb.getEmployees();
                     
                   for(Model e:list) { 
                       
        %>
             <TR>
               <TD><%=e.getFullname()%></TD>
                <TD> <%=e.getComname()%></TD>
                <TD> <%=e.getAge()%></TD>
                <TD> <%=e.getDepartment()%></TD>
                <TD> <%=e.getSalary()%></TD>
                <TD> <%=e.getGender()%></TD>
                <TD> <%=e.getState() %></Td>
                <TD> <%=e.getCity() %></TD>
                <TD> <%=e.getAddress()%></TD>
              <TD><%=e.getTemp()%></TD>
         </TR>
            
           <%} %>          
	             
    </TABLE>
  </form>
</body>
</html>