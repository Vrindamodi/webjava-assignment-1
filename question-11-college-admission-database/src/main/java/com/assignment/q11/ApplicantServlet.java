package com.assignment.q11;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/applicants")
public class ApplicantServlet extends HttpServlet {

    // add a new applicant
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String applicationId = request.getParameter("applicationId");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String course = request.getParameter("course");

        if (applicationId == null || applicationId.trim().equals("") || name == null || name.trim().equals("")
                || phone == null || phone.trim().equals("") || course == null || course.trim().equals("")) {
            request.setAttribute("error", "All fields are required.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        // PreparedStatement keeps the user input safe from SQL injection
        String sql = "INSERT INTO applicants (application_id, name, phone, course) VALUES (?, ?, ?, ?)";
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, applicationId.trim());
            ps.setString(2, name.trim());
            ps.setString(3, phone.trim());
            ps.setString(4, course.trim());
            ps.executeUpdate();
            con.close();
            response.sendRedirect("applicants");
        } catch (SQLIntegrityConstraintViolationException e) {
            request.setAttribute("error", "Application ID " + applicationId + " already exists.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Could not save applicant: " + e.getMessage(), e);
        }
    }

    // show all applicants
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Applicant> list = new ArrayList<Applicant>();
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM applicants ORDER BY application_id");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Applicant(rs.getString("application_id"), rs.getString("name"),
                        rs.getString("phone"), rs.getString("course")));
            }
            con.close();
        } catch (SQLException e) {
            throw new ServletException("Could not load applicants: " + e.getMessage(), e);
        }
        request.setAttribute("applicants", list);
        request.getRequestDispatcher("applicants.jsp").forward(request, response);
    }
}
