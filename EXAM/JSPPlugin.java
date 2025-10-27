// ========================================
// FILE 1: HelloApplet.java
// Location: HelloApplet.java
// ========================================

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class HelloApplet extends Applet {
    
    public void init() {
        // Set background color
        setBackground(Color.YELLOW);
    }
    
    public void paint(Graphics g) {
        // Set text color and font
        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        
        // Draw text
        g.drawString("HELLO WORLD!", 150, 100);
        g.drawString("Running from JSP Plugin", 100, 150);
    }
}


// ========================================
// FILE 2: appletDemo.jsp
// Location: appletDemo.jsp (root of webapp)
// ========================================

<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Plugin Tag Demo</title>
</head>
<body>
    <h1>JSP Plugin Tag - Applet Example</h1>
    
    <p>This page demonstrates the use of &lt;jsp:plugin&gt; tag</p>
    
    <!-- Using jsp:plugin tag to run applet -->
    <jsp:plugin type="applet" code="HelloApplet.class" width="500" height="300">
        
        <!-- Fallback message if applet cannot run -->
        <jsp:fallback>
            <p style="color: red; font-weight: bold;">
                Sorry! Unable to start the applet.<br>
                Your browser may not support Java applets.
            </p>
        </jsp:fallback>
        
    </jsp:plugin>
    
    <p><b>Note:</b> The applet is embedded using JSP plugin tag.</p>
    
</body>
</html>