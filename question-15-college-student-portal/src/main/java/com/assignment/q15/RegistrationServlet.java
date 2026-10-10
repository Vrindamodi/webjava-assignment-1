package com.assignment.q15;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    // show the registration form
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedIn") == null) {
            response.sendRedirect("index.jsp");
            return;
        }
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    // save the student information in the session
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedIn") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        String id = request.getParameter("studentId");
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        String semester = request.getParameter("semester");
        String email = request.getParameter("email");

        if (id == null || id.trim().equals("") || name == null || name.trim().equals("")
                || department == null || department.trim().equals("")
                || semester == null || semester.trim().equals("")
                || email == null || email.trim().equals("")) {
            request.setAttribute("error", "All fields are required.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        if (!email.contains("@") || !email.contains(".")) {
            request.setAttribute("error", "Please enter a valid email address.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        StudentBean student = new StudentBean();
        student.setStudentId(id.trim());
        student.setName(name.trim());
        student.setDepartment(department.trim());
        student.setSemester(semester.trim());
        student.setEmail(email.trim());

        session.setAttribute("studentProfile", student);
        response.sendRedirect("profile");
    }
}
