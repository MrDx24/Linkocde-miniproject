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
	<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
	<link rel="stylesheet" href="styles.css" type="text/css">
</head>
<body>

<%!int size = 0 ; %>
<%!int data = 0; %>
<% ArrayList lst = (ArrayList)session.getAttribute("products"); %>
<% if(lst==null) {size = 0;}else{size = lst.size();} %>

	<nav class="navbar navbar-inverse fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">WebSiteName</a>
			</div>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-list-alt"></span>History </a></li>
				<li><a href="DisplayCart.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Cart </a>
				<span class="badge"><%= size %></span> 
				</li>
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>Logout </a></li>
			</ul>
		</div>
	</nav>
	
	<div class="row">
	<h2 style="text-align: center;">Stationary Products</h2> <hr>
	<%! ArrayList<ProductDetails> pd = new ArrayList(); %>
	<%! ProductDao pdao = new ProductDao(); %>
	<% pd = pdao.getProducts(); %>

	<% for(int i=0; i<pd.size() ;i++) { %>
		<div class="row cont">
			<form action="ProductServlet" method="post" class="formGroup ">
				<div class="formGroup">
					<%-- <c:out value="${'Welcome to javaTpoint'}"/>   --%>
					<label for="productName">Product Name</label><br>
					<input id="productName" class="form-control" type="text" name="productName"  value=<%= pd.get(i).getPnames() %> readonly>

					<label id="prQtlbl" for="productQuantity">Product Quantity</label><br>
					<input id="productQuantity" class="form-control" type="number" name="productQuantity" required="required">

					<label id="ptprlbl" for="productPrice">Product Price</label>
					<input id="productPrice" class="form-control" type="text" name="productPrice"  value=<%= pd.get(i).getPprice() %> readonly>

					<button type="submit" class="btn btn-block btn-primary" >Add item to cart</button>
					
					
					
				</div>

			</form>

		</div>
		<% } %>
	</div>
	

</body>
</html>