<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
function goFunction(){
	alert("hello")
	
	window.location.replace("testLogout.jsp",'window','toolbar=1,location=1,directories=1,status=1,menubar=1,scrollbars=1,resizable=1');
	self.close()
}

</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="javascript:goFunction()">Logout Session </a>

</body>
</html>