package com.assignment.q11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/college_admission?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";

    public static Connection getConnection() throws SQLException {
        // the password is read from an environment variable so it is not written in the code
        String password = System.getenv("DB_PASSWORD");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL driver not found");
        }
        return DriverManager.getConnection(URL, USER, password);
    }
}
