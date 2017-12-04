<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="login.css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>

	<div id="header"><%@include file="header.jsp"%></div>
	<div id="login">


		<%
			String error = (String) request.getAttribute("loginerror");
			if (error != null) {
		%>

		<span style="color: red"> <%=error%></span>
		<%
			}
		%>
		<br> <br>
		<form name="login" action="login" method="post">
			Username: <input type="text" name="username" value="user"/><br><br> 
			Password: <input type="password" name="password" /><br><br> 
			<input type="submit" name="action" value="Login" />&nbsp; 
			<input type="Reset" value="Reset" /> 
			<input type="hidden" name="page" value="login" />
		</form>

	</div>
</body>
</html>