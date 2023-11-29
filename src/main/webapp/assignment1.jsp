<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Hello Page</title>
</head>
<body >
	<%
	String name = (String) session.getAttribute("name");

	// Check if the user is logged in
	if (name == null || name.isEmpty()) {
	%>
	<!-- Login Form -->
	<form action="login" method="post">
		<label for="name">Enter your name:</label> <input type="text"
			id="name" name="name" required> <input type="submit"
			value="Login">
	</form>
	<%
	} else {
	long startTimeMillis = (long) session.getAttribute("time");
	String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(startTimeMillis));
	%>
	<!-- Hello Page -->
	<div style="display: flex; justify-content: space-between; width: 100%;">
		<h2>
			Hello,
			<%=name%>
		</h2>
		<p id="time"><%=formattedDate%></p>
	</div>

	<form action="logout	" method="post">
		<input type="submit" value="Logout">
	</form>
	<%
	}
	%>
</body>
</html>
