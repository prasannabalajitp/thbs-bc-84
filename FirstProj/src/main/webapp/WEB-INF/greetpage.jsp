<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Greetings Page</title>
</head>
<body>
<% String name = (String) request.getAttribute("name"); %>
 
<%out.println(name); %><br>
${name}
${pass}
</body>
</html>