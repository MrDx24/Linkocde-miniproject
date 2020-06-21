<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
	<link rel="stylesheet" href="style.css" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	
<style type="text/css">
	body {
		background-image: url("images/login.jpg"); 
		background-repeat: no-repeat; 
		background-size: cover;
	}
</style>
</head>
<body>
	
	<div id="" class="container loginForm">
		<h2>Login Form</h2>
		<form action="LoginController" method="post" class="formGroup">
			<div class="formGroup">
                <label for="username">Username : </label> 
                <input type="text" class="form-control" id="username"  name="username"  autocomplete="off" required="required">
			</div>
			<div class="formGroup">
                <label for="password">Password:</label> 
                <input type="password" class="form-control" id="password" name="password" required="required">
			</div>

			<div class="formGroup btn-group btn-block btngrp">
				<button id="loginBtn" type="submit" class="btn btn-primary">Submit</button>
				<a href="Register.jsp" id="register" style="text-decoration: none;">New User ? <b>Sign up</b></a>
			</div>
			
		</form>
	</div>
	
</body>
</html>