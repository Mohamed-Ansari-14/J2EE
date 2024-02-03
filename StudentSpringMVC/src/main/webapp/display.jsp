<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<body>

<table border="2px">
<tr>
<th>ID</th>
<th>Name</th>
<th>Address</th>
<th>Phone</th>
<th>Delete</th>
<th>Update
</th>
</tr>

<c:forEach var="student" items="${list}">
<tr>
<td>${student.id }</td>
<td>${student.name }</td>
<td>${student.address }</td>
<td>${student.phone }</td>
<td><a href="delete?id=${student.id }">Delete</a></td>
<td><a href="update?id=${student.id }">Update</a></td>
</tr>

</c:forEach>

</body>
</html>