<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<div>
	<br>
	<br>
	<br>
	<br>
	<form name="help" action="help" method="post">
	<input type = "submit" name="helpaction" value = "Help"/>&nbsp;
	<input type="hidden" name="help" value="Help" />
	</form>
	<br>
	<br>
	<form name="logout"  action="login" method="post">
	<input type = "submit" name="action" value = "Logout"/>&nbsp;
	<input type="hidden" name="session" value="Session" />
	
	</form>
	</div>	
</body>
</html>