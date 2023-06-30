<%@page import="in.co.rays.bean.UserBean"%>
<%@page import="java.beans.beancontext.BeanContext"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form >
	<%@ include file = "Header.jsp" %>
		<%
			List list = (List) request.getAttribute("List");
			Iterator it = list.iterator();
		%>


		<table border ="1">
			<tr>
				<th>Id</th>
				<th>firstName</th>
				<th>lastName</th>
				<th>loginId</th>
				<th>password</th>
				<th>Address</th>
				<th>edit</th>
			</tr>
			<tr>
				<%
					while (it.hasNext()) {

						UserBean bean = (UserBean) it.next();
				%>

			</tr>
			<tr>
				<td><%=bean.getId()%></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getLoginId()%></td>
				<td><%=bean.getPassword()%></td>
				<td><%=bean.getAddress()%></td>
				<td><a href = "UserCtl.do?id=<%=bean.getId()%>">edit</a></td>
			</tr>
			<%
				}
			%>
		</table>

	</form>

</body>
 </html>