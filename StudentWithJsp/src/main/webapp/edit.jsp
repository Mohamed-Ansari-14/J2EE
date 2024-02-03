<%@page import="student.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Student student=(Student)request.getAttribute("student"); %>
<%String message = (String)request.getAttribute("message"); %>
<% if(message!=null){ %>
<h1><%= message %></h1>
<%}else{ %>
<h1><%= "Welcome to Update Page" %></h1>
<%} %>

<form action="edit" method="post">

Id: <input type="number" name="id" value="<%= student.getId()%>" readonly="readonly">
<br><br>
Name: <input type="text" name="name" value="<%= student.getName()%>">
<br><br>
Age: <input type="number" name="age" value="<%= student.getAge()%>">
<br><br>
Address: <input type="text" name="address" value="<%= student.getAddress()%>">
<br><br>
Mobile Number: <input type="tel" name="phone" value="<%= student.getPhone()%>">
<br><br>
Email: <input type="email" name="email" value="<%= student.getEmail()%>">
<br><br>
Password: <input type="password" name="password" value="<%= student.getPassword()%>">
<br><br>
<input type="submit" value="Edit">

</form>

</body>
</html>