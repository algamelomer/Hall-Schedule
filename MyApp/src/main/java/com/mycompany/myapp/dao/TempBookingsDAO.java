/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.dao;

import com.mycompany.myapp.model.TempBookings;
import com.mycompany.myapp.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omar
 */
public class TempBookingsDAO {

    public List<TempBookings> getTempBookings() {
        List<TempBookings> tempBookingsList = new ArrayList<>();
        String query = "SELECT * FROM temp_bookings";

        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                TempBookings tempBookings = new TempBookings(
                        rs.getInt("id"),
                        rs.getString("reason"),
                        rs.getInt("users_id"),
                        rs.getInt("class_rooms_id")
                );
                tempBookingsList.add(tempBookings);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tempBookingsList;
    }

    public TempBookings getTempBookingId(int TempBookingId) {
        String query = "SELECT * FROM temp_bookings WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, TempBookingId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new TempBookings(
                        rs.getInt("id"),
                        rs.getString("reason"),
                        rs.getInt("users_id"),
                        rs.getInt("class_rooms_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
