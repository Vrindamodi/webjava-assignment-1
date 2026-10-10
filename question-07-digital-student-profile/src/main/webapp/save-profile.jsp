<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="student" class="com.assignment.q7.StudentBean" scope="session" />
<jsp:setProperty name="student" property="*" />
<html>
<body>
<h2>Profile Saved</h2>
<p>The student details are stored in a JavaBean and can be viewed on other pages.</p>
<a href="profile.jsp">Personal Details</a> |
<a href="academic.jsp">Academic Details</a>
</body>
</html>
