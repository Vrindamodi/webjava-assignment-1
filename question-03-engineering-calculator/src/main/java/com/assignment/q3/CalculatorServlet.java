package com.assignment.q3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        try {
            double a = Double.parseDouble(request.getParameter("number1"));
            double b = Double.parseDouble(request.getParameter("number2"));
            String op = request.getParameter("operation");
            double result;

            if (op.equals("add")) {
                result = a + b;
            } else if (op.equals("subtract")) {
                result = a - b;
            } else if (op.equals("multiply")) {
                result = a * b;
            } else if (op.equals("divide")) {
                if (b == 0) {
                    out.println("Error: cannot divide by zero");
                    return;
                }
                result = a / b;
            } else {
                out.println("Error: unknown operation");
                return;
            }
            out.println("Result: " + result);
        } catch (Exception e) {
            out.println("Error: please enter valid numbers");
        }
    }
}
