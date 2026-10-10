<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>College Admission</title></head>
<body>
<h2>Add Applicant</h2>
<% if (request.getAttribute("error") != null) { %>
    <p style="color:red"><%= request.getAttribute("error") %></p>
<% } %>
<form method="post" action="applicants">
    Application ID: <input type="text" name="applicationId"><br><br>
    Name: <input type="text" name="name"><br><br>
    Phone: <input type="text" name="phone"><br><br>
    Course: <input type="text" name="course"><br><br>
    <input type="submit" value="Save Applicant">
</form>
<br>
<a href="applicants">View All Applicants</a>
</body>
</html>
