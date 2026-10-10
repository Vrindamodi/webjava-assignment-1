package com.assignment.q2;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("studentName");
        String rollNumber = request.getParameter("rollNumber");
        String department = request.getParameter("department");
        String email = request.getParameter("email");

        // validate the form data
        String error = null;
        if (name == null || name.trim().equals("") || rollNumber == null || rollNumber.trim().equals("")
                || department == null || department.trim().equals("") || email == null || email.trim().equals("")) {
            error = "All fields are required.";
        } else if (!email.contains("@") || !email.contains(".")) {
            error = "Please enter a valid email address.";
        }

        // forward to the error page or the confirmation page
        RequestDispatcher rd;
        if (error != null) {
            request.setAttribute("error", error);
            rd = request.getRequestDispatcher("error.jsp");
        } else {
            request.setAttribute("studentName", name);
            request.setAttribute("rollNumber", rollNumber);
            request.setAttribute("department", department);
            request.setAttribute("email", email);
            rd = request.getRequestDispatcher("confirmation.jsp");
        }
        rd.forward(request, response);
    }
}
