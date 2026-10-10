<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="registration" class="com.assignment.q8.CourseRegistrationBean" scope="request" />
<jsp:setProperty name="registration" property="*" />
<html>
<body>
<h2>Course Registration Confirmed</h2>
<table border="1" cellpadding="6">
    <tr><td>Student ID</td><td><jsp:getProperty name="registration" property="studentId" /></td></tr>
    <tr><td>Name</td><td><jsp:getProperty name="registration" property="name" /></td></tr>
    <tr><td>Department</td><td><jsp:getProperty name="registration" property="department" /></td></tr>
    <tr><td>Course</td><td><jsp:getProperty name="registration" property="course" /></td></tr>
</table>
<br>
<a href="index.jsp">New Registration</a>
</body>
</html>
