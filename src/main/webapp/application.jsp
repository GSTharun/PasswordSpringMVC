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
	<form:form action="saveapplication" modelAttribute="application">

		<form:label path="id">Id</form:label>
		<form:input path="id" />

		<form:label path="username">UserName</form:label>
		<form:input path="username" />

		<form:label path="gender">Gender</form:label>
		<form:input path="gender" />


		<form:label path="dateofbirth">DOB</form:label>
		<form:input path="dateofbirth" />


		<form:label path="email">Email</form:label>
		<form:input path="email" />

		<form:label path="password">Password</form:label>
		<form:input path="password" />

		<select name="applicationtype" id=applicationtype>
			<option value="gmail">Gmail:</option>
			<option value="Facebook">FaceBook:</option>
			<option value="instagram">InstaGram:</option>
		</select>

		<input type="submit" value="submit">

	</form:form>
</body>
</html>