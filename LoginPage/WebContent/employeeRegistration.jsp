<%@ page language="java" contentType="text/html; charset=ISO-8859-8"
    pageEncoding="ISO-8859-8"%>
<!DOCTYPE html>
<<html lang="en">

<head>
<title>Insert title here</title>
<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 <style type="text/css">

.required
{
color:red;
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

function checkSel()
{
	if(document.form1.city.value=="")
	{
		alert("please select state first");
		return false;
	}
	else{
		return true;
	}
	}

</script>


<body>
<h3 align="center" >EMPLOYEE REGISTRATION FORM</h3>
<br></br>

<form action="Register" name="form1" onsubmit="return(validation())"  method="post" >
<table align="center">    
    <tr> 
     <td><label for="fullname">Full Name <span style="color:red">*</span></label></td>    
     <td><input type="text" name="fullname" /><div id="fullname"  class="text-danger"></div>
     </td>    
    </tr>
     
    <tr>    
     <td><label for="comname">Company Name <span style="color:red">*</span></label> </td>    
     <td><input type="text" name="comname" /><div id="comname"  class="text-danger"></div>   
     </td>    
    </tr> 
   
  
   
    <tr>    
     <td><label for="age">Age <span class="required">*</span></label></td>    
     <td><input type="text" name="age" /><div id="age"  class="text-danger"></div>    
     </td>    
    </tr> 
    
    
    
    <tr>   
     <td> 
      <label for="department">Department <span class="required">*</span></label><div id="department" class="text-danger"></div></td>
     <td><select name="department" id="department" value="">
     <option value="0">Select</option>
       <option value="Development">Development</option>    
       <option value="Testing">Testing</option>    
       <option value="Networking">Networking</option>    
       <option value="Finance">Finance</option>    
       <option value="Management">Management</option>    
     </select>  
     </td>  
    </tr>  
   
   
    <tr>    
     <td><label for="salary">Salary <span class="required">*</span></label></td>    
     <td><input type="text" name="salary"  /><div id="salary"  class="text-danger"></div>   
     </td>    
    </tr>    
         
        
         
    <tr>    
     <td><label for="gender">Gender <span class="required">*</span></label></td>    
     <td><input type="radio" name="gender" value="male" id="male"/>Male   
      <input type="radio" name="gender" value="female" id="female"/>Female
      <input type="radio" name="gender" value="other" id="other">Other
      <div id="gender"  class="text-danger"></div> 
      </td>    
    </tr>
      
    
    <tr>    
     <td><label for="state">State <span class="required">*</span></label><div id="state" class="text-danger"></div></td>    
     <td><select name="state" onchange="switchState(this);"> 
     	<option selected="" value=""  >select</option>
       <option value="Karnataka">Karnataka</option>    
        <option value="Maharashtra">Maharashtra</option>    
       </select>    
     </td>    
    </tr> 
    
    
    <tr>    
     <td><label for="city">City <span class="required">*</span></label><div id="city" class="text-danger"></div></td>    
     <td><select name="city" onchange="showSlection()"  id="city" onblur="return(checkSel())">
     	<option selected="" value="">select city</option>
      </select>    
     </td>    
    </tr>  
    
    
    <tr>    
     <td><label for="address">Address <span style="color:red">*</span></label></td>    
     <td><input type="text" name="address" /><div id="address"  class="text-danger"></div>    
     </td>    
    </tr>
    
    <tr>    
          <td><label for="skills">Skills <span class="required">*</span></label></td>    
                 <td><input type="checkbox" name="skills" value="java" id="java"/>Java</td></tr>
                <tr><td><div id="skills" class="text-danger"></div></td>
              	<td><input type="checkbox" name="skills" value="spring" id="spring"/>Spring</td></tr>
                <tr><td></td>
                <td><input type="checkbox" name="skills" value="j2ee" id="j2ee"/>J2EE</td>
                </tr>
                <tr><td></td>
                 <td><input type="checkbox" name="skills" value="sql" id="sql"/>SQL</td></tr>
                 <tr><td></td>
                 <td><input type="checkbox" name="skills" value="hibernate" id="hibernate"/>Hibernate</td></tr>
   </tr> 
     
        <tr>
           <td>
              	<input type="submit" value="submit" />
                <input type="reset" value="Clear" />
              
          </td>
       </tr>
                   
      
    
   </table>  

</form>
<script type="text/javascript">
function validation()

{
	var regex = /^[a-zA-Z\s]*$/;
if((document.form1.fullname.value==""))
 {
  document.getElementById('fullname').innerHTML = "pls enter fullname";
  form1.fullname.focus();
  return(false);
 }
if(!regex.test(document.form1.fullname.value))
{
 document.getElementById('fullname').innerHTML = "only chars allowed and spaces";
 form1.fullname.focus();
 return(false);
}


if(document.form1.comname.value=="")
  {
  document.getElementById('comname').innerHTML = "pls enter company name";
  form1.comname.focus();
  return(false);
 }

if(document.form1.age.value=="")
  {
  document.getElementById('age').innerHTML = "enter age of the employee";
  form1.age.focus();
  return(false);
  }
if(document.form1.department.value=="0")
{
document.getElementById('department').innerHTML = "Enter the department of the employee";
form1.department.focus();
return(false);
}

  
if((document.getElementById('male').checked==false)&&(document.getElementById('female').checked==false)&&(document.getElementById('other').checked==false))
{
	document.getElementById('gender').innerHTML = "pls select the gender button";
	 return(false); 
	
	}
if(document.form1.salary.value=="")
   {
  document.getElementById('salary').innerHTML = "Please enter salary";
  form1.salary.focus();
  return(false);
   }
if(document.form1.state.value=="")
{
document.getElementById('state').innerHTML = "Please enter state";
form1.state.focus();
return(false);
}

if(document.form1.city.value=="")
{
document.getElementById('city').innerHTML = "Please select state first and select city";
form1.city.focus();
return(false);
}


if(document.form1.address.value== "")
   {
  document.getElementById('address').innerHTML = "pls enter the address of employee";
 form1.address.focus();
  return(false);
  }
  
  if((document.form1.skills[0].checked==false)&&(document.form1.skills[1].checked==false)&&(document.form1.skills[2].checked==false)&&(document.form1.skills[3].checked==false)&&(document.form1.skills[4].checked==false)){
	  document.getElementById('skills').innerHTML = "pls select atleast one technology which u know";
	  form1.address.focus();
	  return(false);
	     
  }
	  
	  
else
   {
   return(true);
   }
}





</script>


</body>
</html>