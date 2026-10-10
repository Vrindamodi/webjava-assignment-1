<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="student" class="com.assignment.q7.StudentBean" scope="session" />
<html>
<body>
<h2>Personal Details</h2>
<p>Student ID: <jsp:getProperty name="student" property="studentId" /></p>
<p>Name: <jsp:getProperty name="student" property="name" /></p>
<a href="academic.jsp">Academic Details</a> |
<a href="index.jsp">Edit</a>
</body>
</html>
