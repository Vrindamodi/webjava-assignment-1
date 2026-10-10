package com.assignment.q11;

public class Applicant {
    private String applicationId;
    private String name;
    private String phone;
    private String course;

    public Applicant(String applicationId, String name, String phone, String course) {
        this.applicationId = applicationId;
        this.name = name;
        this.phone = phone;
        this.course = course;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCourse() {
        return course;
    }
}
