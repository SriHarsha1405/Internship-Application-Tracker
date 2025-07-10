package dao;

import model.Application;
import java.sql.*;
import java.util.*;

public class ApplicationDAO {
    public void applyToInternship(Application app) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO applications (student_id, internship_id, apply_date, status) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, app.getStudentId());
            ps.setInt(2, app.getInternshipId());
            ps.setDate(3, app.getApplyDate());
            ps.setString(4, app.getStatus());
            ps.executeUpdate();
            System.out.println("Application submitted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Application> getApplicationsByStudent(int studentId) {
        List<Application> applications = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM applications WHERE student_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Application app = new Application(
                    rs.getInt("application_id"),
                    rs.getInt("student_id"),
                    rs.getInt("internship_id"),
                    rs.getDate("apply_date"),
                    rs.getString("status")
                );
                applications.add(app);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applications;
    }

    public void updateApplicationStatus(int applicationId, String newStatus) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "UPDATE applications SET status = ? WHERE application_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, newStatus);
            ps.setInt(2, applicationId);
            ps.executeUpdate();
            System.out.println("Application status updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}