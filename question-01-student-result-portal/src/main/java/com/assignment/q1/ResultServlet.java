package com.assignment.q1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("studentName");
        String rollNumber = request.getParameter("rollNumber");

        try {
            double m1 = Double.parseDouble(request.getParameter("subject1"));
            double m2 = Double.parseDouble(request.getParameter("subject2"));
            double m3 = Double.parseDouble(request.getParameter("subject3"));

            if (m1 < 0 || m1 > 100 || m2 < 0 || m2 > 100 || m3 < 0 || m3 > 100) {
                out.println("<h3>Marks must be between 0 and 100.</h3>");
                out.println("<a href='index.html'>Go back</a>");
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

            out.println("<html><body>");
            out.println("<h2>Student Result</h2>");
            out.println("Name: " + name + "<br>");
            out.println("Roll Number: " + rollNumber + "<br>");
            out.println("Total Marks: " + total + " / 300<br>");
            out.println("Percentage: " + String.format("%.2f", percentage) + "%<br>");
            out.println("Grade: " + grade + "<br><br>");
            out.println("<a href='index.html'>Enter another result</a>");
            out.println("</body></html>");
        } catch (NumberFormatException e) {
            out.println("<h3>Please enter numbers for all three subjects.</h3>");
            out.println("<a href='index.html'>Go back</a>");
        }
    }
}
