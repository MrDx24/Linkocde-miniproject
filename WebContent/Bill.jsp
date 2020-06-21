<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.ArrayList"%>
<%@page import="com.model.Bill"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill</title>
	<link rel="stylesheet" href="styles.css" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
	body {
		background-image: url("images/bill.jpg"); 
		background-repeat: no-repeat; 
		background-size: cover;
	}
</style>

</head>
<body>
	

	<h1 align="center"></h1>
	
	<div class="row">
		<div class="container" style="background:#fefefe; border-radius:5px; width: 400px; height: 400px; box-shadow:  0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);">
			<h3>Price Details : </h3>
			<c:set var="b" scope="session" value="${bill}"></c:set>
			<table class="table">
				<tr>
					<td>Bag Total : </td>
						<td style="color: blue; font-weight: bold;">${b.getName()}
					</td>
				</tr>
				
				<tr>
					<td>Bag Total : </td>
						<td style="color: blue; font-weight: bold;">${b.getTotal()}
					</td>
				</tr>
				
				<tr>
					<td>CGST : </td>
						<td style="color: blue; font-weight: bold;">${b.getCgst()}
					</td>
				</tr>
				
				<tr>
					<td>SGST : </td>
						<td style="color: blue; font-weight: bold;">${b.getSgst()}
					</td>
				</tr>
				
				<tr>
					<td>Final Bill : </td>
						<td style="color: green; font-weight: bold;">${b.getFinalBill()}
					</td>
				</tr>
				
			</table>
			<form action="BillServlet" method="post" style=" width: 100%">
				<button class="btn right" type="submit">Place the Order
					<span class="glyphicon glyphicon-arrow-right" style="margin-left: 10px"></span>
				</button>
				<a class="btn btn-primary right" href="DisplayCart.jsp">
					<span class="glyphicon glyphicon-arrow-left" style="margin-right: 10px"></span>
					Go back
				</a>
			</form>
		</div>
	</div>

</body>
</html>