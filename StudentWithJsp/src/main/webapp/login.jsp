<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<%String message = (String)request.getAttribute("message"); %>
<% if(message!=null){ %>
<h1><%= message %></h1>
<%}else{ %>
<h1><%= "Welcome to Login Page" %></h1>
<%} %>
<form action="login" method="post">

Email: <input type="email" name="email">
<br><br>
Password: <input type="password" name="password">
<br><br>
<input type="submit" value="Login">  

</form>

</body>
</html>