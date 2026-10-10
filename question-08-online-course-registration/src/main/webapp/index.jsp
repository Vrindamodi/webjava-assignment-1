<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Course Registration</title></head>
<body>
<h2>Online Course Registration</h2>
<form method="post" action="confirmation.jsp">
    Student ID: <input type="text" name="studentId"><br><br>
    Name: <input type="text" name="name"><br><br>
    Department: <input type="text" name="department"><br><br>
    Course:
    <select name="course">
        <option>Advanced Java</option>
        <option>Web Technology</option>
        <option>Database Systems</option>
    </select><br><br>
    <input type="submit" value="Register">
</form>
</body>
</html>
