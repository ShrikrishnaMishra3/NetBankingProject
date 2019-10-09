<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!doctype html>
<html>
<head>
<title>Register Form</title>
</head>
<body>
<form action="MyBank" Method="GET">	
	<h1>Check your Balance</h1>
	
<table>
	<tr>
		<td>
			Username:
		</td>
		<td>
			<input type="text" placeholder="Username" name="Username">
		</td>
			<td>
	 		<input type="radio" name="CurrentBalance">CurrentBalance
	 		<input type="radio" name="MiniStatement">MiniStatement
	 		<input type="Submit" value="sign in" name="">
	 	</td>
	</tr>
</table>
</form>
</body>
</html>
