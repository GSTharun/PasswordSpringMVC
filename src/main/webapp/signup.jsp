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
	<form:form action="signup" modelAttribute="user">
		<form:label path="name">Name</form:label>
		<form input path="name"></form>

		<form:label path="phoneno">Phoneno</form:label>
		<form input path="phoneno"></form>

		<form:label path="address">Adress</form:label>
		<form input path="address"></form>

		<form:label path="email">Email</form:label>
		<form input path="email"></form>


		<form:label path="password">Password</form:label>
		<form input path="password"></form>

		<input type="submit" value="submit">

	</form:form>
</body>
</html>