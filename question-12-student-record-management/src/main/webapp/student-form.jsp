<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.assignment.q12.Student" %>
<%
    // when editing, the servlet sends the student; after an error it sends the typed values back
    boolean editing = request.getAttribute("student") != null || Boolean.TRUE.equals(request.getAttribute("editMode"));
    String id = "", name = "", department = "", semester = "";

    Student student = (Student) request.getAttribute("student");
    if (student != null) {
        id = student.getStudentId();
        name = student.getName();
        department = student.getDepartment();
        semester = "" + student.getSemester();
    }
    if (request.getAttribute("formStudentId") != null) {
        id = (String) request.getAttribute("formStudentId");
        name = (String) request.getAttribute("formName");
        department = (String) request.getAttribute("formDepartment");
        semester = (String) request.getAttribute("formSemester");
    }
%>
<html>
<head><title>Student Form</title></head>
<body>
<h2><%= editing ? "Edit Student" : "Add Student" %></h2>
<% if (request.getAttribute("error") != null) { %>
    <p style="color:red"><%= request.getAttribute("error") %></p>
<% } %>
<form method="post" action="students">
    <input type="hidden" name="action" value="<%= editing ? "update" : "insert" %>">
    Student ID: <input type="text" name="studentId" value="<%= id %>" <%= editing ? "readonly" : "" %>><br><br>
    Name: <input type="text" name="name" value="<%= name %>"><br><br>
    Department: <input type="text" name="department" value="<%= department %>"><br><br>
    Semester: <input type="text" name="semester" value="<%= semester %>"><br><br>
    <input type="submit" value="Save">
</form>
<br>
<a href="students">Back to List</a>
</body>
</html>
