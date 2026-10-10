package com.assignment.q12;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    private StudentDAO dao = new StudentDAO();

    // show the list, the add form or the edit form
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("new".equals(action)) {
                request.getRequestDispatcher("student-form.jsp").forward(request, response);
            } else if ("edit".equals(action)) {
                Student student = dao.getStudent(request.getParameter("studentId"));
                request.setAttribute("student", student);
                request.getRequestDispatcher("student-form.jsp").forward(request, response);
            } else {
                request.setAttribute("students", dao.getAllStudents());
                request.getRequestDispatcher("student-list.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage(), e);
        }
    }

    // insert, update or delete a student
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String id = request.getParameter("studentId");
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        String semesterText = request.getParameter("semester");

        try {
            if ("delete".equals(action)) {
                dao.deleteStudent(id);
                response.sendRedirect("students");
                return;
            }

            // check the form values for add and update
            String error = null;
            int semester = 0;
            if (id == null || id.trim().equals("") || name == null || name.trim().equals("")
                    || department == null || department.trim().equals("")) {
                error = "All fields are required.";
            } else {
                try {
                    semester = Integer.parseInt(semesterText.trim());
                    if (semester <= 0) {
                        error = "Semester must be a positive number.";
                    }
                } catch (Exception e) {
                    error = "Semester must be a positive number.";
                }
            }

            if (error == null) {
                Student student = new Student(id.trim(), name.trim(), department.trim(), semester);
                if ("update".equals(action)) {
                    dao.updateStudent(student);
                } else {
                    dao.addStudent(student);
                }
                response.sendRedirect("students");
            } else {
                showFormWithError(request, response, error);
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            showFormWithError(request, response, "Student ID " + id + " already exists.");
        } catch (SQLException e) {
            throw new ServletException("Database error: " + e.getMessage(), e);
        }
    }

    // send the user back to the form with the values they typed
    private void showFormWithError(HttpServletRequest request, HttpServletResponse response, String error)
            throws ServletException, IOException {
        request.setAttribute("error", error);
        request.setAttribute("editMode", "update".equals(request.getParameter("action")));
        request.setAttribute("formStudentId", request.getParameter("studentId"));
        request.setAttribute("formName", request.getParameter("name"));
        request.setAttribute("formDepartment", request.getParameter("department"));
        request.setAttribute("formSemester", request.getParameter("semester"));
        request.getRequestDispatcher("student-form.jsp").forward(request, response);
    }
}
