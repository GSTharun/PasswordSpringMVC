<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
<th>Name</th>
<th>Phoneno</th>
<th>Address</th>
<th>Email</th>
<th>Password</th>
<th>View</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<tr>
<td>${user.id}</td>
<td>${user.name}</td>
<td>${user.phoneno}</td>
<td>${user.address}</td>
<td>${user.email}</td>
<td>${user.password}</td>
<td><a href="view?id=${user.id}">View</a></td>
<td><a href="edit?id=${user.id}">Edit</a></td>
<td><a href="delete?id=${user.id}">Delete</a></td></tr>

</table>
</body>
</html>