<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.assignment.q15.StudentBean" %>
<%
    if (session.getAttribute("loggedIn") == null) {
        response.sendRedirect("index.jsp");
        return;
    }

    // show the registered name if there is one, otherwise the username
    String displayName = (String) session.getAttribute("username");
    StudentBean student = (StudentBean) session.getAttribute("studentProfile");
    if (student != null) {
        displayName = student.getName();
    }
%>
<html>
<body>
<h2>Welcome, <%= displayName %></h2>
<a href="register">Register Basic Information</a> |
<a href="profile">View Profile</a> |
<a href="logout">Logout</a>
</body>
</html>
