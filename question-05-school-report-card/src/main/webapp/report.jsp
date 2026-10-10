<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Report Card</title></head>
<body>
<%
    String name = request.getParameter("studentName");
    String roll = request.getParameter("rollNumber");

    try {
        double m1 = Double.parseDouble(request.getParameter("subject1"));
        double m2 = Double.parseDouble(request.getParameter("subject2"));
        double m3 = Double.parseDouble(request.getParameter("subject3"));

        if (m1 < 0 || m1 > 100 || m2 < 0 || m2 > 100 || m3 < 0 || m3 > 100) {
%>
            <h3>Marks must be between 0 and 100.</h3>
<%
        } else {
            double total = m1 + m2 + m3;
            double percentage = total / 3;
            String grade;
            if (percentage >= 90) {
                grade = "A+";
            } else if (percentage >= 80) {
                grade = "A";
            } else if (percentage >= 70) {
                grade = "B";
            } else if (percentage >= 60) {
                grade = "C";
            } else if (percentage >= 50) {
                grade = "D";
            } else {
                grade = "F";
            }
%>
            <h2>Report Card</h2>
            <table border="1" cellpadding="6">
                <tr><td>Name</td><td><%= name %></td></tr>
                <tr><td>Roll Number</td><td><%= roll %></td></tr>
                <tr><td>Subject 1</td><td><%= m1 %></td></tr>
                <tr><td>Subject 2</td><td><%= m2 %></td></tr>
                <tr><td>Subject 3</td><td><%= m3 %></td></tr>
                <tr><td>Total</td><td><%= total %> / 300</td></tr>
                <tr><td>Percentage</td><td><%= String.format("%.2f", percentage) %>%</td></tr>
                <tr><td>Grade</td><td><%= grade %></td></tr>
            </table>
<%
        }
    } catch (NumberFormatException e) {
%>
        <h3>Please enter numbers for all three subjects.</h3>
<%
    }
%>
<br>
<a href="index.jsp">Back</a>
</body>
</html>
