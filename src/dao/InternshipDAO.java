package dao;

import model.Internship;
import java.sql.*;
import java.util.*;

public class InternshipDAO {
    public void addInternship(Internship internship) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO internships (title, company_name, location, duration, description) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, internship.getTitle());
            ps.setString(2, internship.getCompanyName());
            ps.setString(3, internship.getLocation());
            ps.setString(4, internship.getDuration());
            ps.setString(5, internship.getDescription());
            ps.executeUpdate();
            System.out.println("Internship added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Internship> getAllInternships() {
        List<Internship> internships = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM internships";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Internship i = new Internship(
                    rs.getInt("internship_id"),
                    rs.getString("title"),
                    rs.getString("company_name"),
                    rs.getString("location"),
                    rs.getString("duration"),
                    rs.getString("description")
                );
                internships.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return internships;
    }
}