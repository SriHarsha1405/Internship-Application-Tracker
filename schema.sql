CREATE DATABASE IF NOT EXISTS internship_db;
USE internship_db;

CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(20),
    resume_link VARCHAR(255)
);

CREATE TABLE internships (
    internship_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    company_name VARCHAR(100),
    location VARCHAR(100),
    duration VARCHAR(50),
    description TEXT
);

CREATE TABLE applications (
    application_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    internship_id INT,
    apply_date DATE,
    status VARCHAR(50),
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (internship_id) REFERENCES internships(internship_id)
);

