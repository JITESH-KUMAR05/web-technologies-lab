// ========================================
// FILE 1: HelloWorldServlet.java
// Location: src/HelloWorldServlet.java
// ========================================

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorldServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head><title>Hello World</title></head>");
        out.println("<body>");
        out.println("<h1>HELLO WORLD</h1>");
        out.println("<p>This is a simple servlet example.</p>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
}


// ========================================
// FILE 2: web.xml
// Location: WEB-INF/web.xml
// ========================================

<?xml version="1.0" encoding="UTF-8"?>
<web-app>
    
    <servlet>
        <servlet-name>HelloWorldServlet</servlet-name>
        <servlet-class>HelloWorldServlet</servlet-class>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>HelloWorldServlet</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
    
    <welcome-file-list>
        <welcome-file>index.html</welcome-file>
    </welcome-file-list>
    
</web-app>


// ========================================
// FILE 3: index.html (Optional Homepage)
// Location: index.html (root of webapp)
// ========================================

<!DOCTYPE html>
<html>
<head>
    <title>Servlet Example</title>
</head>
<body>
    <h2>Welcome to Servlet Example</h2>
    <p>Click the link below to see the Hello World servlet:</p>
    <a href="hello">Click Here for Hello World Servlet</a>
</body>
</html>