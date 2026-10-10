<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<h2>Student Profile</h2>
<table border="1" cellpadding="6">
    <tr><td>Student ID</td><td>${student.studentId}</td></tr>
    <tr><td>Name</td><td>${student.name}</td></tr>
    <tr><td>Department</td><td>${student.department}</td></tr>
    <tr><td>Semester</td><td>${student.semester}</td></tr>
    <tr><td>Email</td><td>${student.email}</td></tr>
</table>
<br>
<a href="register">Edit Profile</a> |
<a href="dashboard.jsp">Dashboard</a> |
<a href="logout">Logout</a>
</body>
</html>
