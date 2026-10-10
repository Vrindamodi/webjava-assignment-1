<%@ page contentType="text/html;charset=UTF-8" %>
<%
    // go back to login if the user is not logged in
    String name = (String) session.getAttribute("studentName");
    if (name == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<html>
<body>
<h2>Welcome, <%= name %></h2>
<p>You are logged in to the college portal.</p>
<a href="profile.jsp">View Profile</a> |
<a href="logout.jsp">Logout</a>
</body>
</html>
