/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;

import com.mycompany.myapp.dao.SchedulesDAO;
import com.mycompany.myapp.model.Schedules;
import java.util.List;

/**
 *
 * @author omar
 */
public class Test {

    public static void main(String[] args) {
        SchedulesDAO schedulesDAO = new SchedulesDAO();

        List<Schedules> schedulesList = schedulesDAO.getSchedules();

        for (Schedules schedule : schedulesList) {
            System.out.println("ID: " + schedule.getId());
            System.out.println("Day of Week: " + schedule.getDay_of_week());
            System.out.println("Start Time: " + schedule.getStart_time());
            System.out.println("End Time: " + schedule.getEnd_time());
            System.out.println("Type: " + schedule.getType());
            System.out.println("Status: " + schedule.getStatus());
            System.out.println("Course ID: " + schedule.getCourses_course_id());
            System.out.println("Class Room ID: " + schedule.getClass_rooms_id());
            System.out.println("Temp Booking ID: " + schedule.getTemp_bookings_id());
            System.out.println("-----------------------------------");
        }
    }
}
