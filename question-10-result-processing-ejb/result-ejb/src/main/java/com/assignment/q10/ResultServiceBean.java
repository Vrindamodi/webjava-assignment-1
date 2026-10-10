package com.assignment.q10;

import javax.ejb.Stateless;

@Stateless
public class ResultServiceBean implements ResultServiceRemote {

    public StudentResult process(String rollNumber, double subject1, double subject2, double subject3) {
        if (subject1 < 0 || subject1 > 100 || subject2 < 0 || subject2 > 100
                || subject3 < 0 || subject3 > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }

        double total = subject1 + subject2 + subject3;
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

        return new StudentResult(rollNumber, total, percentage, grade);
    }
}
