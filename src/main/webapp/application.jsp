<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=1px>
<form:form action="saveapplication" modelAttribute="application">


		<tr>
		<td><form:label path="username">Username</form:label></td>
		<td><form:input path="username" /></td>
		</tr>
		
		<tr>
		<td><label>Gender</label></td>
		<td><select name="gender" id=gender>
			<option value="male">MALE</option>
			<option value="female">FEMALE</option></td>
		</select>
		</tr>
		
		<tr>
		<td><form:label path="dateofbirth">DOB</form:label></td>
		<td><form:input path="dateofbirth" /></td>
		</tr>
		
		<tr>
		<td><form:label path="email">Email</form:label></td>
		<td><form:input path="email" /></td>
		</tr>

		<tr>
		<td><form:label path="password">Password</form:label></td>
		<td><form:input path="password" /></td>
		</tr>
		
		<tr>
		<td><label>Application Type</label></td>
		<td><select name="applicationtype" id=applicationtype>
			<option value="gmail">Gmail</option>
			<option value="Facebook">FaceBook</option>
			<option value="instagram">InstaGram</option></td>
		</select>
		</tr>
		
	
		</table>
		<br>
		<input type="submit" value="submit">
		<a href="applogin"><button type="button" class="back">Back</button></a>
		
	</form:form>


</body>
</html>