<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Hello World JSP</title>
</head>
<body>
    <h1>HELLO WORLD</h1>
    <p>This is a simple JSP page.</p>
    
    <%
        // Java code inside JSP
        out.println("<p>Current Date and Time: " + new java.util.Date() + "</p>");
    %>
</body>
</html>