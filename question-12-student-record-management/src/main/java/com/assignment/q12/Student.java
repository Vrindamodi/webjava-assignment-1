package com.assignment.q12;

public class Student {
    private String studentId;
    private String name;
    private String department;
    private int semester;

    public Student(String studentId, String name, String department, int semester) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.semester = semester;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSemester() {
        return semester;
    }
}
