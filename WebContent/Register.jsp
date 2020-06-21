<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
	<link rel="stylesheet" href="style.css" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	
<style type="text/css">
	body {
		background-image: url("images/register.jpg"); 
		background-repeat: no-repeat; 
		background-size: cover;
	}
</style>
</head>

<body>
	
	<div id="" class="container registerForm">
		<h2>Register Form</h2>
		<form action="RegisterController" method="post" class="formGroup">
			<div class="formGroup">
                <label for="fullname">Full name : </label> 
                <input type="text" class="form-control" id="fullname" name="fullname" autocomplete="off" required="required">
			
                <label for="username">User name : </label> 
                <input type="text" class="form-control" id="username" name="username" autocomplete="off" required="required">
			
                <label for="password">Password:</label> 
                <input type="password" class="form-control" id="password" name="password" required="required">
			
                <label for="mobile">Mobile : </label> 
                <input type="text" class="form-control" id="mobile" name="mobile" autocomplete="off" required="required">
			
				<a href="Login.jsp" id="frgpsswd">Go back to login</a>
			

				<div class="btn-group btn-block ">
					<button id="registerBtn" type="submit" class="btn btn-primary btn-block">Register</button>
					
				</div>
			</div>
		</form>
	</div>

</body>
</html>