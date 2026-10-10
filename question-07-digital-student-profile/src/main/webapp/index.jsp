<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Digital Student Profile</title></head>
<body>
<h2>Create Student Profile</h2>
<form method="post" action="save-profile.jsp">
    Student ID: <input type="text" name="studentId"><br><br>
    Name: <input type="text" name="name"><br><br>
    Department: <input type="text" name="department"><br><br>
    Semester: <input type="text" name="semester"><br><br>
    <input type="submit" value="Save Profile">
</form>
</body>
</html>
