<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>School Report Card</title></head>
<body>
<h2>School Report Card Generator</h2>
<form method="post" action="report.jsp">
    Student Name: <input type="text" name="studentName"><br><br>
    Roll Number: <input type="text" name="rollNumber"><br><br>
    Subject 1 marks: <input type="text" name="subject1"><br><br>
    Subject 2 marks: <input type="text" name="subject2"><br><br>
    Subject 3 marks: <input type="text" name="subject3"><br><br>
    <input type="submit" value="Generate Report Card">
</form>
</body>
</html>
