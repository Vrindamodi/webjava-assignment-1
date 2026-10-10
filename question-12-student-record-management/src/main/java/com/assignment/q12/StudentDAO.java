package com.assignment.q12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// All the database work for students is done in this class
public class StudentDAO {

    public void addStudent(Student s) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students (student_id, name, department, semester) VALUES (?, ?, ?, ?)");
        ps.setString(1, s.getStudentId());
        ps.setString(2, s.getName());
        ps.setString(3, s.getDepartment());
        ps.setInt(4, s.getSemester());
        ps.executeUpdate();
        con.close();
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<Student>();
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM students ORDER BY student_id");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new Student(rs.getString("student_id"), rs.getString("name"),
                    rs.getString("department"), rs.getInt("semester")));
        }
        con.close();
        return list;
    }

    public Student getStudent(String studentId) throws SQLException {
        Student student = null;
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE student_id = ?");
        ps.setString(1, studentId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            student = new Student(rs.getString("student_id"), rs.getString("name"),
                    rs.getString("department"), rs.getInt("semester"));
        }
        con.close();
        return student;
    }

    public void updateStudent(Student s) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "UPDATE students SET name = ?, department = ?, semester = ? WHERE student_id = ?");
        ps.setString(1, s.getName());
        ps.setString(2, s.getDepartment());
        ps.setInt(3, s.getSemester());
        ps.setString(4, s.getStudentId());
        ps.executeUpdate();
        con.close();
    }

    public void deleteStudent(String studentId) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE student_id = ?");
        ps.setString(1, studentId);
        ps.executeUpdate();
        con.close();
    }
}
