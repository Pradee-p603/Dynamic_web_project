<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
	

		<form action="UserCtl" method="post">
			<table style="margin: 150px; border: 2px solid green; padding: 30px">

				<tr>
					<th>first Name</th>
					<td><input type="text" name="firstName"></td>

				</tr>

				<tr>
					<th>last Name</th>
					<td><input type="text" name="lastName"></td>
				</tr>

				<tr>
					<th>loginId</th>
					<td><input type="text" name="loginId"></td>
				</tr>

				<tr>
					<th>password</th>
					<td><input type="text" name="password"></td>
				</tr>

				<tr>
					<th>address</th>
					<td><input type="text" name="address"></td>
				</tr>




				<th></th>
				<td><input style="margin-left: 60px" type="submit"
					name="Operation" value="signup"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>