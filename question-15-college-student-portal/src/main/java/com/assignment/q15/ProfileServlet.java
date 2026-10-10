package com.assignment.q15;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedIn") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        StudentBean student = (StudentBean) session.getAttribute("studentProfile");
        if (student == null) {
            // the student has not registered yet
            response.sendRedirect("register");
            return;
        }
        request.setAttribute("student", student);
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }
}
