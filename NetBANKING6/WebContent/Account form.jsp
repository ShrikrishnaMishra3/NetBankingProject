<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<body>
<form action="net" Method="post">
<a href>Back!</a>
<h1>Create a new account for free!</h1>
<table>
	<tr>
		<td>
			Name:
		</td>
		<td>
			<input type="text" placeholder=" FirstName" name="FirstName">
		</td>
		<td>
			<input type="text" placeholder="MiddleName" name="MiddleName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<td>
			<input type="text" placeholder="LastName" name="LastName">
		</td>
	</tr>
	<tr>
		<td>
			AddressLine1:
		</td>
		<td>
			<input type="AddressLine1" placeholder="AddressLine1" name="AddressLine1">
		</td>

	</tr>
		<tr>
		<td>
			AddressLine2:
		</td>
		<td>
			<input type="AddressLine2" placeholder="AddressLine2" name="AddressLine2">
		</td>
		
	</tr>
	 <tr>
	 	<td>
	 		Gender:
	 	</td>
	 	<td>
	 		<input type="radio" name="Gender">Male
	 		<input type="radio" name="Gender">Female
	 	</td>
	 </tr>
	  <tr>
	 	<td>
	 		DOB:
	 	</td>
	 	<td>
	 		<input type="date" name="DOB">
	
	 	</td>
	 </tr>
	 <tr>
	 	<td>
	 		Email:
	 	</td>
	 	<td>
	 		<input type="Mail" placeholder="Email" name="Email">
	 	</td>
	 </tr>
	 <tr>
	 	<td>
	 		PhoneNo:
	 	</td>
	 	<td>
	 		<select>
	 		<option>+115</option>
	 		<option>+92</option>
	 		<option>+8</option>
	 		<option>+5</option>
	 		<option>+1</option>
	 		<option>+91</option>
	 		</select>
	 		<input type="Phone" name="PhoneNo">
	 	</td>
	 </tr>
	 	<tr>
		<td>
			City:
		</td>
		<td>
			<input type="City" placeholder="City" name="City">
		</td>
		
	</tr>	<tr>
		<td>
			Pincode:
		</td>
		<td>
			<input type="Pincode" placeholder="Pincode" name="Pincode">
		</td>
			<tr>
		<td>
			Username:
		</td>
		<td>
			<input type="Username" placeholder="Username" name="Username">
		</td>
		
	</tr>
		<tr>
		<td>
			Password:
		</td>
		<td>
			<input type="Password" placeholder="Password" name="Password">
		</td>
		
	</tr>
		<tr>
		<td>
			RePassword:
		</td>
		<td>
			<input type="Password" placeholder="Re-Password" name="RePassword">
		</td>
		
	</tr>
		
	</tr>

	 <tr>
	 	<td>
	 		<input type="Submit" value="Submit" name="">
	 	</td>
	 </tr>
</table>
</form>
</body>
</html>