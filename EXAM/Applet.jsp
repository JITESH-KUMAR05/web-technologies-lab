// ========================================
// FILE 1: HelloApplet.java
// Location: WEB-INF/classes/HelloApplet.java
// ========================================

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class HelloApplet extends Applet {
    
    public void init() {
        setBackground(Color.CYAN);
    }
    
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("HELLO WORLD FROM APPLET!", 50, 100);
        
        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("This applet is running from JSP", 50, 150);
    }
}


// ========================================
// FILE 2: runApplet.jsp
// Location: runApplet.jsp (root of webapp)
// ========================================

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Applet Example</title>
    <style>
        body {
            font-family: Arial;
            margin: 50px;
            text-align: center;
        }
        h2 {
            color: #4CAF50;
        }
        .info {
            background-color: #f0f0f0;
            padding: 20px;
            margin: 20px auto;
            width: 80%;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <h2>JSP Plugin Tag - Running Applet</h2>
    
    <div class="info">
        <p>This JSP page uses &lt;jsp:plugin&gt; tag to run an applet</p>
    </div>
    
    <!-- JSP Plugin tag to run applet -->
    <jsp:plugin type="applet" code="HelloApplet.class" width="600" height="300">
        <jsp:params>
            <jsp:param name="message" value="Hello from JSP!" />
        </jsp:params>
        <jsp:fallback>
            <p style="color: red;">
                <b>Unable to load applet!</b><br>
                Your browser does not support Java applets or Java is not installed.
            </p>
        </jsp:fallback>
    </jsp:plugin>
    
    <div class="info">
        <p><b>Note:</b> Modern browsers no longer support Java applets due to security concerns.</p>
        <p>This is for educational/exam purposes only.</p>
    </div>
    
</body>
</html>


// ========================================
// FILE 3: simpleApplet.jsp (Alternative - Simple Version)
// Location: simpleApplet.jsp
// ========================================

<%@ page language="java" contentType="text/html"%>
<html>
<head>
    <title>Simple JSP Applet</title>
</head>
<body>
    <h2>Running Applet using JSP Plugin Tag</h2>
    
    <jsp:plugin type="applet" code="HelloApplet.class" width="500" height="200">
        <jsp:fallback>
            <p>Unable to start applet!</p>
        </jsp:fallback>
    </jsp:plugin>
    
</body>
</html>