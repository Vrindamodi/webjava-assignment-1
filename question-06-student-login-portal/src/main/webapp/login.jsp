<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // simple fixed login for the demo
    if ("student".equals(username) && "college123".equals(password)) {
        session.setAttribute("studentName", "Vrinda Modi");
        response.sendRedirect("dashboard.jsp");
    } else {
        response.sendRedirect("index.jsp?error=1");
    }
%>
