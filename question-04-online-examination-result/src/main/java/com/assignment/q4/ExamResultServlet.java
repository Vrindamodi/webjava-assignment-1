package com.assignment.q4;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exam-result")
public class ExamResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        String roll = request.getParameter("rollNumber");
        try {
            double m1 = Double.parseDouble(request.getParameter("subject1"));
            double m2 = Double.parseDouble(request.getParameter("subject2"));
            double m3 = Double.parseDouble(request.getParameter("subject3"));

            if (roll == null || roll.trim().equals("")) {
                out.println("Error: roll number is required");
                return;
            }
            if (m1 < 0 || m1 > 100 || m2 < 0 || m2 > 100 || m3 < 0 || m3 > 100) {
                out.println("Error: marks must be between 0 and 100");
                return;
            }

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

            out.println("Roll Number: " + roll + ", Total: " + total + ", Percentage: "
                    + String.format("%.2f", percentage) + "%, Grade: " + grade);
        } catch (NumberFormatException e) {
            out.println("Error: please enter valid marks");
        }
    }
}
