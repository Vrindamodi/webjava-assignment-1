CREATE DATABASE IF NOT EXISTS college_admission;
USE college_admission;

CREATE TABLE IF NOT EXISTS applicants (
    application_id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    course VARCHAR(100) NOT NULL
);
