/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.dao;

import com.mycompany.myapp.model.Courses;
import com.mycompany.myapp.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omar
 */
public class CoursesDAO {

    public List<Courses> getAllCourses() {
        List<Courses> coursesList = new ArrayList<>();
        String query = "SELECT * FROM courses";

        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();

            // Loop through the result set and create Department objects
            while (rs.next()) {
                Courses courses = new Courses(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("instructor_id")
                );
                coursesList.add(courses);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coursesList;
    }

    public Courses getCourseByName(String CourseName) {
        String query = "SELECT * FROM Courses WHERE name = ?";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, CourseName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Courses(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("instructor_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Courses getCourseById(int CourseId) {
        String query = "SELECT * FROM Courses WHERE course_id = ?";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, CourseId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Courses(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("instructor_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
