<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border=2px>
<tr>
<th>ID</th>
<th>DOB</th>
<th>Email</th>
<th>Password</th>
<th>Gender</th>
<th>Applicationtype</th>
<th>username</th>
</tr>

<c:forEach items="${list}" var="application">

<tr>
<td>${application.id}</td>
<td>${application.dateofbirth}</td>
<td>${application.email}</td>
<td>${application.password}</td>
<td>${application.gender}</td>
<td>${application.applicationtype}</td>
<td>${application.username}</td>
<td><a href="delete?id=${application.id}">delete</a></td>
<td><a href="edit?id=${application.id}">edit</a></td>
</tr>

</c:forEach>
</table>

</body>
</html>