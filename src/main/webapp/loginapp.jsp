<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border=1px>
	<form:form action="loginapp" modelAttribute="application">
		<br>
		
		<tr>
		<td><form:label path="email">Email</form:label></td>
		<td><form:input path="email" /></td>
		</tr>

		<tr>
		<td><form:label path="password">Password</form:label></td>
		<td><form:input path="password" /></td>
		</tr>
		
		</table>
		<br>
		<input type="submit" value="login">

	</form:form>

</body>
</html>