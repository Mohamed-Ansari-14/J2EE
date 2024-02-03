<%@page import="student.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% List<Student>students=(List)request.getAttribute("list"); %>
<%String name = (String)request.getAttribute("name"); %>
<%if(name != null){ %>
<h1>Changed By: <%=name %></h1>
<%} %>

<table border="2px">
<tr>
<th>ID</th>
<th>Name</th>
<th>Age</th>
<th>Address</th>
<th>Fees</th>
<th>Email</th>
<th>Password</th>
<th>Phone</th>
<th>Delete</th>
<th>Update</th>
</tr>

<%for(Student student:students){ %>
<tr>
<td><%=student.getId() %></td>
<td><%=student.getName()%></td>
<td><%=student.getAge()%></td>
<td><%=student.getAddress() %></td>
<td><%=student.getFees() %></td>
<td><%=student.getEmail() %></td>
<td><%=student.getPassword() %></td>
<td><%=student.getPhone() %></td>
<td><a href="delete?id=<%=student.getId() %>">Delete</a></td>
<td><a href="update?id=<%=student.getId() %>">Update</a></td>
</tr>
<%} %>
</table>

</body>
</html>



















