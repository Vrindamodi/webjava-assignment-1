<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List, com.assignment.q11.Applicant" %>
<html>
<head><title>Applicants</title></head>
<body>
<h2>Registered Applicants</h2>
<table border="1" cellpadding="6">
    <tr>
        <th>Application ID</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Course</th>
    </tr>
    <%
        List<Applicant> applicants = (List<Applicant>) request.getAttribute("applicants");
        for (Applicant a : applicants) {
    %>
    <tr>
        <td><%= a.getApplicationId() %></td>
        <td><%= a.getName() %></td>
        <td><%= a.getPhone() %></td>
        <td><%= a.getCourse() %></td>
    </tr>
    <% } %>
</table>
<br>
<a href="index.jsp">Add Applicant</a>
</body>
</html>
