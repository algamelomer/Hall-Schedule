package com.mycompany.myapp.dao;

import com.mycompany.myapp.model.Schedules;
import com.mycompany.myapp.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

/**
 *
 * @author omar
 */
public class SchedulesDAO {

    // Retrieve all schedules
    public List<Schedules> getSchedules() {
        List<Schedules> schedulesList = new ArrayList<>();
        String query = "SELECT * FROM schedules";

        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Schedules schedule = new Schedules(
                        rs.getInt("id"),
                        rs.getString("day_of_week"),
                        rs.getObject("start_time", LocalTime.class),
                        rs.getObject("end_time", LocalTime.class),
                        rs.getString("type"),
                        rs.getString("status"),
                        rs.getInt("courses_course_id"),
                        rs.getInt("class_rooms_id"),
                        rs.getInt("temp_bookings_id")
                );
                schedulesList.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedulesList;
    }

    // Retrieve a specific schedule by ID
    public Schedules getScheduleById(int scheduleId) {
        String query = "SELECT * FROM schedules WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, scheduleId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Schedules(
                        rs.getInt("id"),
                        rs.getString("day_of_week"),
                        rs.getObject("start_time", LocalTime.class),
                        rs.getObject("end_time", LocalTime.class),
                        rs.getString("type"),
                        rs.getString("status"),
                        rs.getInt("courses_course_id"),
                        rs.getInt("class_rooms_id"),
                        rs.getInt("temp_bookings_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
