/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.dao;

import com.mycompany.myapp.model.ClassRooms;
import com.mycompany.myapp.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omar
 */
public class ClassRoomsDAO {

    public List<ClassRooms> getAllCourses() {
        List<ClassRooms> classRoomsList = new ArrayList<>();
        String query = "SELECT * FROM class_rooms";

        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                ClassRooms classRooms = new ClassRooms(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("capacity")
                );
                classRoomsList.add(classRooms);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classRoomsList;
    }

    public ClassRooms getClassRoomByName(String ClassRoomName) {
        String query = "SELECT * FROM class_rooms WHERE name = ?";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, ClassRoomName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new ClassRooms(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("capacity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ClassRooms getClassRoomById(int ClassRoomId) {
        String query = "SELECT * FROM class_rooms WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, ClassRoomId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new ClassRooms(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("capacity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
