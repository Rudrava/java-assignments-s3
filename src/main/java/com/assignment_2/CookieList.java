package com.assignment_2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list-cookies")
public class CookieList extends HttpServlet {
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        // Get all cookies from the request
	        Cookie[] cookies = request.getCookies();

	        // Set the response content type
	        response.setContentType("text/html");

	        // Get the PrintWriter
	        PrintWriter out = response.getWriter();

	        // Display the list of cookies
	        out.println("<html><head><title>List Cookies</title></head><body>");
	        out.println("<h2>List of Cookies:</h2>");

	        if (cookies != null) {
	            out.println("<ul>");
	            for (Cookie cookie : cookies) {
	                out.println("<li>" + cookie.getName() + " : " + cookie.getValue() + "</li>");
	            }
	            out.println("</ul>");
	        } else {
	            out.println("<p>No cookies found.</p>");
	        }

	        out.println("</body></html>");
	    }
}
