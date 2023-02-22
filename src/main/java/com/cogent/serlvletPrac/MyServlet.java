package com.cogent.serlvletPrac;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/hi")
public class MyServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
			
			out.println("<html>");
	        out.println("<head>");
	        out.println("<title> welcome page </title>");
	        out.println("</head>");

	        out.println("<body >");
	        out.println("<h1> Welcome! Keyu </h1>");
	        out.println("<div>\r\n"
	        		+ "<h2> Java 8 </h2>\r\n"
	        		+ "<ul>\r\n"
	        		+ "  <li>Java 8 is the latest release for Java that contains new features, enhancements and bug fixes to improve efficiency to develop and run Java programs. The new release of Java is first made available to developers to give adequate time for testing and certification before being made available on the java.com website for end users to download.\r\n"
	        		+ "\r\n"
	        		+ "</li>\r\n"
	        		+ "  <li>Starting with the January 2015 Critical Patch Update release, users with the auto update feature enabled are being asked to update from Java 7 to Java 8. Also, please note the April 2015 CPU release will be the last Java 7 publicly available update. For more information, and details on how to receive longer term support for Java 7, please see the Oracle Java SE Support Roadmap.\r\n"
	        		+ "\r\n"
	        		+ "</li>\r\n"
	        		+ "  <li>Some application providers might require that you use a particular Java release and have not certified their applications with Java 8. If you experience problems running an application with Java 8, check with your application provider and confirm that it is certified with this version.\r\n"
	        		+ "</li>\r\n"
	        		+ "</ul>\r\n"
	        		+ "</div>");
			out.println("<h2> Today is </h2>");
			out.println("<h3> February 22, 2023 </h3>");

			out.println("</body>");
			out.println("</html>");

	}
	
}
