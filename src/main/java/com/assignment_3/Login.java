package com.assignment_3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/age-login")
public class Login extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String name = req.getParameter("name");
		Integer age = Integer.parseInt(req.getParameter("age"));
		if (age < 18) {
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			out.println("<html><head><title>Unauthorized Page</title></head><body>");
			out.println("Hello " + name + ", you are not authorized to visit the site");
			out.println("</body></html>");
			return;
		}

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><head><title>Unauthorized Page</title></head><body>");
		out.println("Welcome " + name + " to this site.");
		out.println("</body></html>");
		return;
	}
}
