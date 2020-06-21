<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="com.model.Order"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
	<link rel="stylesheet" href="styles.css" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
	body {
		background-image: url("images/cart.jpg"); 
		background-repeat: no-repeat; 
		background-size: cover;
	}
</style>

</head>
<body>

	<a class="btn btn-primary" href="Product.jsp"  style="margin: 20px 20px; float: left" >
		<span class="glyphicon glyphicon-arrow-left" style="margin-right: 10px"></span>
		Back

	</a>
	<form action="CartServlet" method="post" id="bill"  style="float: right;">
	
		<div id="billbtn" class="btn-block" >
			<span id="textdata" style="margin-top: 20px" >Click here to proceed further : </span>
			<button class="btn btn-success" type="submit"  style="margin: 0px 20px; " >Proceed to bill
			<span class="glyphicon glyphicon-arrow-right" style="margin-left: 10px"></span>
			</button>
		</div>
	</form>
	
	
	<table class="table table-bordered tablecustom">
	<thead class="thead-dark">
	<tr>
			<th>
				OrderId
			</th>
			<th>
				ProductName
			</th>
			<th>
				ProductQuantity
			</th>
			<th>
				ProductPrice
			</th>
	</tr>
	</thead>
	<tbody>
	
	
	<c:set var="lstpr" scope="session" value="${products}"></c:set>
	<c:if test="${lstpr==null}">
	<tr>
		<td colspan="4" style="text-align: center;">No items in cart</td>
	</tr>
	</c:if>

	<c:if test="${lstpr!=null}">
	
	<c:forEach items="${lstpr}" var="l">
		<tr>
			<td> ${l.getOrderid()} </td>
			<td> ${l.getProductName()} </td>
			<td> ${l.getProductQuantity()} </td>
			<td>Rs ${l.getProductPrice()} </td>
		</tr>
	</c:forEach>
	</c:if>
	
	</tbody>
	</table>

</body>
</html>