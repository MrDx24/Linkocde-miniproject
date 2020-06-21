<%@page import="com.dao.ProductDao"%>
<%@page import="com.model.ProductDetails"%>
<%@page import="java.util.ArrayList"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="styles.css" type="text/css">

<style type="text/css">
	body {
		background-image: url("images/home.jpg"); 
		background-repeat: no-repeat; 
		background-size: cover;
	}
</style>

</head>
<body>


	<c:set var="lst" scope="session" value="${products}"></c:set>

	<c:if test="${lst==null}">
		<c:set var="size" scope="session" value="${0}"></c:set>
	</c:if>
	<c:if test="${lst!=null}">
		<c:set var="size" scope="session" value="${lst.size()}"></c:set>
	</c:if>

	<nav class="navbar navbar-inverse fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">
				<img alt="Stampy" src="images/logo.PNG" style="width: 150px; border-radius: 5px; margin-top: -15px;"></a>
			</div>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-list-alt"></span>History </a></li>
				<li><a href="DisplayCart.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Cart </a>
				<span class="badge">${size}</span> 
				</li>
				<li><a href="Login.jsp"><span class="glyphicon glyphicon-log-in"></span>Logout </a></li>
			</ul>
		</div>
	</nav>
	
	<div class="row">
	<h2 style="text-align: center;">Stationary Products</h2> <hr>
	<%! ArrayList<ProductDetails> pd = new ArrayList(); %>
	<%! ProductDao pdao = new ProductDao(); %>
	<% pd = pdao.getProducts(); %>
	<% session.setAttribute("test",pd); %>

	<c:forEach items="${test}" var="p" >
	
		<div class="row cont">
			<form action="ProductServlet" method="post" class="formGroup ">
				<div class="formGroup">
					<%-- <c:out value="${'Welcome to javaTpoint'}"/>   --%>
					<label for="productName">Product Name</label><br>
					<input id="productName" class="form-control" type="text" name="productName"  value="${p.getPnames()}" readonly>

					<label id="prQtlbl" for="productQuantity">Product Quantity</label><br>
					<input id="productQuantity" class="form-control" type="number" min="1" max="10" name="productQuantity" required="required">

					<label id="ptprlbl" for="productPrice">Product Price</label>
					<input id="productPrice" class="form-control" type="text" name="productPrice"  value="${p.getPprice()}" readonly>

					<button type="submit" class="btn btn-block btn-primary" >Add item to cart</button>
					
					
					
				</div>

			</form>

		</div>
		
		</c:forEach> 
	</div>
	

</body>
</html>