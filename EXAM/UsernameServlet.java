// ========================================
// FILE 1: login.html
// Location: login.html (root of webapp)
// ========================================

<!DOCTYPE html>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
    <h2>User Login</h2>
    <form action="LoginServlet" method="post">
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username" required></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" required></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Login">
                    <input type="reset" value="Clear">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>


// ========================================
// FILE 2: LoginServlet.java
// Location: src/LoginServlet.java
// ========================================

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Set response content type
        response.setContentType("text/html");
        
        // Get username and password from request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Get PrintWriter to write response
        PrintWriter out = response.getWriter();
        
        // Generate dynamic HTML
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login Details</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; margin: 50px; }");
        out.println("table { border-collapse: collapse; }");
        out.println("td { padding: 10px; border: 1px solid #ddd; }");
        out.println(".header { background-color: #4CAF50; color: white; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<h2>Login Successful!</h2>");
        out.println("<h3>Your Details:</h3>");
        
        out.println("<table>");
        out.println("<tr class='header'>");
        out.println("<td><b>Field</b></td>");
        out.println("<td><b>Value</b></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Username</td>");
        out.println("<td>" + username + "</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Password</td>");
        out.println("<td>" + password + "</td>");
        out.println("</tr>");
        
        out.println("</table>");
        
        out.println("<br><br>");
        out.println("<a href='login.html'>Back to Login</a>");
        
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
    
    // Also handle GET method
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}


// ========================================
// FILE 3: web.xml
// Location: WEB-INF/web.xml
// ========================================

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
         http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">
    
    <servlet>
        <servlet-name>LoginServlet</servlet-name>
        <servlet-class>LoginServlet</servlet-class>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>LoginServlet</servlet-name>
        <url-pattern>/LoginServlet</url-pattern>
    </servlet-mapping>
    
    <welcome-file-list>
        <welcome-file>login.html</welcome-file>
    </welcome-file-list>
    
</web-app>