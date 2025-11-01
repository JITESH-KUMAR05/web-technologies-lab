// ========================================
// FILE 1: index.html
// Location: index.html (root of webapp)
// ========================================

<!DOCTYPE html>
<html>
<head>
    <title>GET and POST Demo</title>
    <style>
        body { font-family: Arial; margin: 50px; }
        .form-container { margin: 20px 0; padding: 20px; border: 1px solid #ddd; }
        h3 { color: #4CAF50; }
    </style>
</head>
<body>
    <h1>HTTP Servlet Methods Demonstration</h1>
    
    <!-- GET Method Form -->
    <div class="form-container">
        <h3>1. GET Method Example</h3>
        <p>GET method appends data to URL (visible in address bar)</p>
        <form action="DemoServlet" method="get">
            <label>Name: </label>
            <input type="text" name="name" required><br><br>
            <label>Email: </label>
            <input type="email" name="email" required><br><br>
            <input type="submit" value="Submit using GET">
        </form>
    </div>
    
    <!-- POST Method Form -->
    <div class="form-container">
        <h3>2. POST Method Example</h3>
        <p>POST method sends data in request body (not visible in URL)</p>
        <form action="DemoServlet" method="post">
            <label>Name: </label>
            <input type="text" name="name" required><br><br>
            <label>Email: </label>
            <input type="email" name="email" required><br><br>
            <input type="submit" value="Submit using POST">
        </form>
    </div>
    
</body>
</html>


// ========================================
// FILE 2: DemoServlet.java
// Location: src/DemoServlet.java
// ========================================

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DemoServlet extends HttpServlet {
    
    // Handle GET requests
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        // Get parameters from request
        
        // Generate response
        out.println("<html>");
        out.println("<head><title>GET Method Response</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; margin: 50px; }");
        out.println(".get { background-color: #e7f3ff; padding: 20px; border-left: 5px solid #2196F3; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<div class='get'>");
        out.println("<h2>GET Method Called</h2>");
        out.println("<p><b>Method Type:</b> GET</p>");
        out.println("<p><b>Name:</b> " + name + "</p>");
        out.println("<p><b>Email:</b> " + email + "</p>");
        out.println("<p><b>Note:</b> Check the URL - parameters are visible!</p>");
        out.println("</div>");
        
        out.println("<br><a href='index.html'>Back to Home</a>");
        out.println("</body></html>");
        
        out.close();
    }
    
    // Handle POST requests
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Get parameters from request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        
        // Generate response
        out.println("<html>");
        out.println("<head><title>POST Method Response</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; margin: 50px; }");
        out.println(".post { background-color: #e7ffe7; padding: 20px; border-left: 5px solid #4CAF50; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<div class='post'>");
        out.println("<h2>POST Method Called</h2>");
        out.println("<p><b>Method Type:</b> POST</p>");
        out.println("<p><b>Name:</b> " + name + "</p>");
        out.println("<p><b>Email:</b> " + email + "</p>");
        out.println("<p><b>Note:</b> Check the URL - parameters are NOT visible (sent in request body)!</p>");
        out.println("</div>");
        
        out.println("<br><a href='index.html'>Back to Home</a>");
        out.println("</body></html>");
        
        out.close();
    }
}


// ========================================
// FILE 3: web.xml
// Location: WEB-INF/web.xml
// ========================================

<?xml version="1.0" encoding="UTF-8"?>
<web-app>
    
    <servlet>
        <servlet-name>DemoServlet</servlet-name>
        <servlet-class>DemoServlet</servlet-class>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>DemoServlet</servlet-name>
        <url-pattern>/DemoServlet</url-pattern>
    </servlet-mapping>
    
    <welcome-file-list>
        <welcome-file>index.html</welcome-file>
    </welcome-file-list>
    
</web-app>