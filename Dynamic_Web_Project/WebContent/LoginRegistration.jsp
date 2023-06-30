<%@page import="java.awt.Color"%>
<%@page import="java.awt.Font"%>
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
		<%@ include file="Header.jsp"%>
		<%
			String error = (String) request.getAttribute("error");
			String uri = (String)request.getAttribute("uri");
		%>
		<%
			if (error != null) {
		%>
		<font color="red"> <%=error%>
		</font>

		<%
			}
		%>
		<form action="LoginCtl" method="post">


			<table style="margin: 150px; border: 2px solid green; padding: 30px">

				<tr>
					<th>loginId</th>
					<td><input type="text" name="loginId"></td>
				</tr>

				<tr>
					<th>password</th>
					<td><input type="password" name="password"></td>
				</tr>
				<th></th>
				<td><input style="margin-left: 60px" type="submit" name = "Operation"
					value="Login"></td>
				</tr>
				</tr>
				<th></th>
				<td><input style="margin-left: 60px" type="submit" name = "Operation"
					value="signup"></td>
				</tr>
				<td><input type="hidden" name="uri" value=<%=uri%>></td>
			</table>
		</form>
		<%@ include file="Footer.jsp"%>
	</center>
</body>
</html>


</body>
</html>