<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>

<form:form action="save" modelAttribute="student">

Name::<form:input path="name"/>
Address::<form:input path="address"/>
Phone::<form:input path="phone"/>

<input type="submit" value="Submit">
</form:form>

</body>
</html>