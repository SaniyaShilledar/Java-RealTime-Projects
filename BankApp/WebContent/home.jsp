t7<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session=request.getSession();
out.println("Welcome"+" "+session.getAttribute("name"));
%><br>
<a href="CheckBalance">check balance</a>
<br>
<a href ="changePwd.jsp">Change Password</a>
<br>
<a href="transfer.jsp">Amount Transfer</a>
<br>
<a href="GetStatement">Get Statement</a>
<br>
<a href="Logout">Logout</a>
</body>
</html>