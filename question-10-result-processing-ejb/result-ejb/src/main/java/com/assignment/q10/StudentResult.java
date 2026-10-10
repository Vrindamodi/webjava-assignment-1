package com.assignment.q10;

import java.io.Serializable;

public class StudentResult implements Serializable {
    private String rollNumber;
    private double total;
    private double percentage;
    private String grade;

    public StudentResult(String rollNumber, double total, double percentage, String grade) {
        this.rollNumber = rollNumber;
        this.total = total;
        this.percentage = percentage;
        this.grade = grade;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public double getTotal() {
        return total;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getGrade() {
        return grade;
    }
}
