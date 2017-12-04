<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.cart.beans.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="checkoutstyling.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<div id="header"><%@include file="header.jsp"%></div>

	<div id="menu"><%@include file="menu.jsp"%></div>

	<div id="footer"><%@include file="footer.jsp"%></div>

	<%!ArrayList<CheckoutValues> al = new ArrayList<CheckoutValues>();%>

	<%
		al = (ArrayList<CheckoutValues>) session.getAttribute("selectedlist");
		for (CheckoutValues c : al) {
			int id = c.getId();
			String name = c.getName();
			double price = c.getPrice();
			int quant = c.getQuantity();
	%>
	<div id="content">
		<form name="table" action="cart" method="post">
			<table>
				<tr>
					
					
					<td style="padding:2px"><%=name%>   :     </td>
					<td><%=quant%>  :     </td>
					<%double result=quant*price;%>
					<td>$<%=result %></td>
					
				</tr>
				<%-- <%=id%>
	<%=name%>
	<%=price%>
	<%=quant%>
	<br> --%>

				<%
					}
				%>
			
</body>
</html>