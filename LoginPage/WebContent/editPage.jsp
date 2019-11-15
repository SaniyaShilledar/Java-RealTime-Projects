<%@ page language="java" contentType="text/html; charset=ISO-8859-8"
    pageEncoding="ISO-8859-8"%>
    <%@ page import="java.sql.*,java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Insert title here</title>
<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<style type="text/css">
.required {
  color: red;
}

</style>

</head>

<script type="text/javascript">
var states= [ ];
states["Karnataka"]   = ["Belgaum","Dharawad","Hubbali","Bangalore"];
states["Maharashtra"] =  ["Pune","Mumbai","Nagapur","Nashik"];

function switchState(selState) {
var citySel = selState.form.city;
for ( var s = citySel.options.length-1; s > 0; --s )  {
citySel.options[s] = null;
}

var chosen = selState.options[selState.selectedIndex].text;
var cList = states[chosen];
if ( cList != null )   {
for ( var i = 0; i < cList.length; ++i )   {
citySel.options[i+1] = new Option(cList[i],cList[i]);
}
}

}

function showSelection() {
var state = document.forms[0].State.value;
var city = document.forms[0].City.value;
if (city != "") {
alert ("You selected " + city + " in " + state);
}
}




</script>

<body>
<br><br>
<h3 align="center">EMPLOYEEMENT REGISTRATION FORM</h3>
<br></br>
<%
String fullname="";
String comname="";
String age="";
String department="";
String salary="";
String gender="";
String state="";
String city="";
String address="";
String skills="";
String eid="";
List dataList=null;
%>
<%
session=request.getSession();
eid=(String)session.getAttribute("eid");

%>

<%
session=request.getSession();
dataList = (ArrayList)session.getAttribute("dataList");
		fullname=dataList.get(0).toString();
		comname=dataList.get(1).toString();
		age=dataList.get(2).toString();
		department=dataList.get(3).toString();
		salary=dataList.get(4).toString();
		gender=dataList.get(5).toString();
		state=dataList.get(6).toString();
		city=dataList.get(7).toString();
		address=dataList.get(8).toString();
		skills=dataList.get(9).toString();
		
		String techskills[]=skills.split(",");
		
		
%>
<form action="Update" method="post" name="form1">

<table align="center" >
<tr>
 <td><input type="hidden" name="eid" value="<%=eid%>" /></td>
</tr>
<tr>
<td><label for="fullname">Full Name <span class="required">*</span></label> </td>    
     <td><input type="text" name="fullname" value="<%=fullname%>" />    
     </td> 
</tr>

<tr>    
     <td><label for="comname">Company Name <span class="required">*</span></label> </td>    
     <td><input type="text" name="comname" id="fullname" value="<%=comname%>" />    
     </td>    
</tr>
 
<tr>    
     <td><label for="age">Age <span class="required">*</span></label></td>    
     <td><input type="text" name="age" id="fullname" value="<%=age%>" />    
     </td>    
</tr> 

<tr>    
     <td><label for="department">Department <span class="required">*</span></label></td>    
     <td><select name="department" id="department" value=""/> 
       <option value="0">select</option>
       <option value="Development" <%=department.equals("Development") ? "selected='selected'" : "" %>>Development</option>    
       <option value="Testing" <%=department.equals("Testing") ? "selected='selected'" : "" %>>Testing</option>    
       <option value="Networking" <%=department.equals("Networking") ? "selected='selected'" : "" %>>Networking</option>    
       <option value="Finance" <%=department.equals("Finance") ? "selected='selected'" : "" %>>Finance</option>    
       <option value="Management" <%=department.equals("Management") ? "selected='selected'" : "" %>>Management</option>    
     </select>    
     </td>    
</tr>  

<tr>    
     <td><label for="salary">Salary <span class="required">*</span></label></td>    
     <td><input type="text" name="salary" id="fullname" value="<%=salary%>" />    
     </td>    
</tr>    
    
<tr>    
     <td><label for="gender">Gender <span class="required">*</span></label></td>    
     <td><input type="radio" name="gender" <%=gender.equals("male") ? "checked='checked'" : "" %>/>Male   
      <input type="radio" name="gender"  <%=gender.equals("female") ? "checked='checked'" : "" %>/>Female
      <input type="radio" name="gender"  <%=gender.equals("other") ? "checked='checked'" : "" %>/>Other
      </tr>

 <tr>    
     <td><label for="state">State <span class="required">*</span></label></td>    
     <td><select name="state" onchange="switchState(this);"> 
     	<option selected="" value="0" >select</option>
        <option value="Karnataka" <%=state.equals("Karnataka") ? "selected='selected'" : "" %>>Karnataka</option>    
        <option value="Maharashtra" <%=state.equals("Maharashtra") ? "selected='selected'" : "" %>>Maharashtra</option>    
       </select>    
     </td>    
    </tr> 
    
    
<tr>    
     <td><label for="city">City <span class="required">*</span></label></td>    
     <td><select name="city" onchange="showSlection()"> 
     <option selected="" value="">select</option>
     </select>    
     </td>    
 </tr>  
    
<tr>    
     <td><label for="address">Address <span class="required">*</span></label></td>    
     <td><input type="text" name="address" id="address" value="<%=address%>"/>   
     </td>    
</tr>
   
<tr>    
         <td><label for="skills">Skills <span class="required">*</span></label></td>    
         <td><input type="checkbox" name="skills" value="java" id="java" <%for(int i=0;i<techskills.length;i++){ %>
         <%=techskills[i].equals("java") ? "checked='checked'" : ""  %> <%} %>/>Java</td></tr>
         <tr><td></td>
         <td><input type="checkbox" name="skills" value="spring" id="spring" <%for(int i=0;i<techskills.length;i++){ %>
         <%=techskills[i].equals("spring") ? "checked='checked'" : ""  %> <%} %>/>Spring</td></tr>
         <tr><td></td>
         <td><input type="checkbox" name="skills" value="j2ee" id="j2ee" <%for(int i=0;i<techskills.length;i++){ %>
         <%=techskills[i].equals("j2ee") ? "checked='checked'" : ""  %> <%} %>/>J2EE</td>
         </tr>
         <tr><td></td>
         <td><input type="checkbox" name="skills" value="sql" id="sql" <%for(int i=0;i<techskills.length;i++){ %>
         <%=techskills[i].equals("sql") ? "checked='checked'" : ""  %> <%} %>/>SQL</td></tr>
         <tr><td></td>
         <td><input type="checkbox" name="skills" value="hibernate" id="hibernate" <%for(int i=0;i<techskills.length;i++){ %>
         <%=techskills[i].equals("hibernate") ? "checked='checked'" : ""  %> <%} %>/>Hibernate</td></tr>
</tr> 
     
    <tr>
          
	   <td><input type="submit" value="Submit"/></td>
	   <td><input type="reset" value="Clear" /></td>
	          
   </tr>
                   
</table>
</body>
</html>