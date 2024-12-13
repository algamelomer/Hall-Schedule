/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.dao;

import com.mycompany.myapp.model.Faculties;
import com.mycompany.myapp.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omar
 */
public class FacultiesDAO {
    // Method to fetch all departments from the database

    public List<Faculties> getAllFaculties() {
        List<Faculties> facultiesList = new ArrayList<>();
        String query = "SELECT * FROM faculties";

        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();

            // Loop through the result set and create Department objects
            while (rs.next()) {
                Faculties faculties = new Faculties(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                facultiesList.add(faculties);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facultiesList;
    }
     public Faculties getFacultyByName(String facultyName) {
        String query = "SELECT * FROM faculties WHERE name = ?";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, facultyName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Faculties(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }
    
}
