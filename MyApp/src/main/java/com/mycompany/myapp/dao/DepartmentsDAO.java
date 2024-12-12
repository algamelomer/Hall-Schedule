package com.mycompany.myapp.dao;

import com.mycompany.myapp.model.Departments;
import com.mycompany.myapp.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentsDAO {

    // Method to fetch all departments from the database
    public List<Departments> getAllDepartments() {
        List<Departments> departmentsList = new ArrayList<>();
        String query = "SELECT * FROM departments";

        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();

            // Loop through the result set and create Department objects
            while (rs.next()) {
                Departments department = new Departments(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("faculties_faculty_id")
                );
                departmentsList.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentsList;
    }

    public List<Departments> getDepartmentsByFaculty_id(int faculty_id) {
        List<Departments> departmentsList = new ArrayList<>();
        String query = "SELECT * FROM departments WHERE faculties_faculty_id = ?";

        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, faculty_id);
            ResultSet rs = pstmt.executeQuery();

            // Loop through the result set and create Department objects
            while (rs.next()) {
                Departments department = new Departments(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("faculties_faculty_id")
                );
                departmentsList.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentsList;
    }
    
    
    public Departments getDepartmentByName(String departmentName) {
        String query = "SELECT * FROM departments WHERE name = ?";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, departmentName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Departments(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("faculties_faculty_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if department is not found
    }

    // Method to fetch a single department based on its ID
    public Departments getDepartmentById(int departmentId) {
        String query = "SELECT * FROM departments WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, departmentId); // Set the department ID in the query
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Departments(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("faculty_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if department is not found
    }
}
