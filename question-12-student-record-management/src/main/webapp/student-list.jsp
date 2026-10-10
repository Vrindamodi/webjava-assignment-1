<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List, com.assignment.q12.Student" %>
<html>
<head><title>Student Records</title></head>
<body>
<h2>Student Records</h2>
<a href="students?action=new">Add Student</a>
<br><br>
<table border="1" cellpadding="6">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Department</th>
        <th>Semester</th>
        <th>Actions</th>
    </tr>
    <%
        List<Student> students = (List<Student>) request.getAttribute("students");
        for (Student s : students) {
    %>
    <tr>
        <td><%= s.getStudentId() %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getDepartment() %></td>
        <td><%= s.getSemester() %></td>
        <td>
            <a href="students?action=edit&studentId=<%= s.getStudentId() %>">Edit</a>
            <form method="post" action="students" style="display:inline">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="studentId" value="<%= s.getStudentId() %>">
                <input type="submit" value="Delete">
            </form>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
