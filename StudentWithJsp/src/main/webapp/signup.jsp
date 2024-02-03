<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp Page</title>
</head>
<body>

<% String message = (String)request.getAttribute("message"); %>
<% if(message != null){ %>
<h1><%=message%></h1>
<%}else{ %>
<h1><%= "Welcome to Sign-Up Page" %></h1>
<%} %>

<form action="signup" method="post">

Enter Name: <input type="text" name="name">
<br><br>
Enter Age: <input type="number" name="age">
<br><br>
Enter Address: <input type="text" name="address">
<br><br>
Enter Mobile Number: <input type="tel" name="phone">
<br><br>
Enter Email: <input type="email" name="email">
<br><br>
Enter Password: <input type="password" name="password">
<br><br>
<input type="submit" value="Sign Up"> 

</form>

</body>
</html>