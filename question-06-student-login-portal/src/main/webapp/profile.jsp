<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String name = (String) session.getAttribute("studentName");
    if (name == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<html>
<body>
<h2>Student Profile</h2>
<p>Name: <%= name %></p>
<p>Course: MCA</p>
<a href="dashboard.jsp">Dashboard</a> |
<a href="logout.jsp">Logout</a>
</body>
</html>
