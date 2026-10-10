<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>College Student Portal</title></head>
<body>
<h2>College Student Portal</h2>
<% if (request.getParameter("error") != null) { %>
    <p style="color:red">Wrong username or password.</p>
<% } %>
<% if (request.getParameter("logout") != null) { %>
    <p>You have been logged out.</p>
<% } %>
<form method="post" action="login">
    Username: <input type="text" name="username"><br><br>
    Password: <input type="password" name="password"><br><br>
    <input type="submit" value="Login">
</form>
</body>
</html>
