package com.assignment_1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet  extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		if(name.isEmpty()) {
			throw new ServletException("Name is required");
		}
		
		HttpSession session = req.getSession();
				
		session.setAttribute("name", name);
		session.setAttribute("time", System.currentTimeMillis());

        res.sendRedirect("assignment1.jsp");
	}
}
