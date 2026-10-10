<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="student" class="com.assignment.q7.StudentBean" scope="session" />
<html>
<body>
<h2>Academic Details</h2>
<p>Department: <jsp:getProperty name="student" property="department" /></p>
<p>Semester: <jsp:getProperty name="student" property="semester" /></p>
<a href="profile.jsp">Personal Details</a> |
<a href="index.jsp">Edit</a>
</body>
</html>
