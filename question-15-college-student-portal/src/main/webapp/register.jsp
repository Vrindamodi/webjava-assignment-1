<%@ page contentType="text/html;charset=UTF-8" %>
<%
    if (session.getAttribute("loggedIn") == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<html>
<body>
<h2>Register Student Information</h2>
<% if (request.getAttribute("error") != null) { %>
    <p style="color:red">${error}</p>
<% } %>
<form method="post" action="register">
    Student ID: <input type="text" name="studentId"><br><br>
    Name: <input type="text" name="name"><br><br>
    Department: <input type="text" name="department"><br><br>
    Semester: <input type="number" name="semester" min="1"><br><br>
    Email: <input type="email" name="email"><br><br>
    <input type="submit" value="Save Profile">
</form>
<a href="dashboard.jsp">Dashboard</a>
</body>
</html>
