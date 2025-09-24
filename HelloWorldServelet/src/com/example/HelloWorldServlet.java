package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>Hello, World!</h1> <h1>This is Jitesh Kumar!</h1></body></html>");
        out.println("<h1>chalo</h1>");
    }
}


// compiled with 
// PS C:\Program Files\Apache Software Foundation> javac -d "C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\MyWebApp\WEB-INF\classes" "C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\MyWebApp\src\com\example\HelloWorldServlet.java"
// PS C:\Program Files\Apache Software Foundation> 