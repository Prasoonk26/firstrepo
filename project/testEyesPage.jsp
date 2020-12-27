<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>

<style>
input#eye {
    position: absolute;
    right: 10px;
    top: 10px;
}
 #reg_password.form-control.input-lg {
    position: relative;
}
.parent{position:absolute;} 
</style>

<script type="text/javascript">

function clickFunction()
{
	alert("In Function");
	
	var vid=document.getElementById("eye").value;
	
	
	alert("Values in "+vid);
	
	if(vid=="on"){
		alert("On Check Box ");
		 
		 
	    $("#points").attr("type", "text");
	    
	 	    	    	    
	}
	else
		{
		alert("Off checkBox");
		
		$("#points").attr("type", "password");
		
		}
	}

</script>
</head>



<body>

<div class="col-md-12 parent" style="margin: 7px;">
    <input type="password" id="points" name="reg_password" style="height: 35px;" class="form-control input-lg" placeholder="Password" ng-model="register_password" /> <input type="checkbox" id="eye" onclick="clickFunction()" />
</div>

</body>
</html>