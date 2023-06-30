<%@page import="in.co.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Header.jsp" %>
	<%
		UserBean bean = (UserBean) request.getAttribute("bean");
	%>
	<form action="UserCtl.do" method="post">

		<td><input type="hidden" name="id" value=<%=bean.getId()%>></td>

		<table style="margin: 150px; border: 2px solid green; padding: 30px">

			<tr>
				<th>first Name</th>
				<td><input type="text" name="firstName"
					value=<%=bean.getFirstName()%>></td>

			</tr>

			<tr>
				<th>last Name</th>
				<td><input type="text" name="lastName"
					value=<%=bean.getLastName()%>></td>
			</tr>

			<tr>
				<th>loginId</th>
				<td><input type="text" name="loginId"
					value=<%=bean.getLoginId()%>></td>
			</tr>

			<tr>
				<th>password</th>
				<td><input type="text" name="password"
					value=<%=bean.getPassword()%>></td>
			</tr>

			<tr>
				<th>address</th>
				<td><input type="text" name="address"
					value=<%=bean.getAddress()%>>></td>
			</tr>
			<tr>
				<th></th>
				<td><input style="margin-left: 60px" type="submit"
					name="Operation" value="Update"></td>
			</tr>
		</table>
	</form>

</body>
</html>