<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="loginRegister" method="post">
		<table style="margin-left: 30px">
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"></td>
			</tr>		
		
			<tr>
				<td>E-mail :</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password1"></td>
			</tr>
			<tr>
				<td>Confirm Password :</td>
				<td><input type="password" name="password2"></td>
			</tr>			
			<tr>
				<td><input type="submit" name="submit" value="register"></td>
			</tr>
		</table>
	</form>
</body>
</html>