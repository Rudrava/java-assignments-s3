package com.assignment_1;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // Retrieve the session
        HttpSession session = req.getSession();
        
        // Get the user's name from the session
        String name = (String) session.getAttribute("name");

        // Calculate the duration of usage
        long startTime = (long) session.getAttribute("time");
        Date startDate = new Date(startTime);
        Date endDate = new Date();
        
        // Format the duration
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        long duration  = endDate.getTime() - startDate.getTime();

        long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
        long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(duration);
;

        // Display the logout message
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html><head><title>Logout Page</title></head><body>");
        out.println("<h2>Thank You, " + name + "!</h2>");
        out.println("<p>Duration of Usage: " + diffInMinutes + " minutes " + diffInSeconds + " seconds " + "</p>");
        out.println("</body></html>");

        // Invalidate the session
        session.invalidate();
	}

}
