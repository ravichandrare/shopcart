<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.cart.beans.Products"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styling.css" />
</head>
<body>

	<div id="header"><%@include file="header.jsp"%></div>

	<div id="menu"><%@include file="menu.jsp"%></div>

	<div id="footer"><%@include file="footer.jsp"%></div>

	<%-- <div id="content"><%@include file="content.jsp"%></div> --%>

	<%!ArrayList<Products> prod = new ArrayList<Products>();
	int id = 0;
	String name = null;
	double price = 0.00;
	int i =0;%>
	

	<div id = "content">
	<form name="table" action="cart" method="post">
	<table>
		<tr>
			<th></th>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>
		<%	prod = (ArrayList<Products>) request.getAttribute("products");
		
		for (Products p : prod) {

				id = p.getId();
				name = p.getName();
				price = p.getPrice();
				i++;
		%>
		<tr>
			<td><input type="checkbox" name = "id" value ="<%=id%>"></td>
			<td><%=id%></td>
			<td><%=name%></td>
			<td><%=price%></td>
			<td><input type="text" name = "quantity"></td>
		</tr>
	<%
		}
	%>
	</table>
	<input type="submit" name = "action" value="Add To Cart" >
	<input type="submit" name = "action" value="CheckOut">
</form>
</div>
</body>
</html>