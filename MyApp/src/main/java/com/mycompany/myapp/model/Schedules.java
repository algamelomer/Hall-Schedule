/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.model;

import java.time.LocalTime;

/**
 *
 * @author omar
 */
public class Schedules {

    private int id;
    private String day_of_week;
    private LocalTime start_time;
    private LocalTime end_time;
    private String type;
    private String status;
    private int courses_course_id;
    private int class_rooms_id;
    private int temp_bookings_id;

    public Schedules() {

    }

    public Schedules(int id, String day_of_week, LocalTime start_time, LocalTime end_time, String type, String status, int courses_course_id, int class_rooms_id, int temp_bookings_id) {
        this.id = id;
        this.day_of_week = day_of_week;
        this.start_time = start_time;
        this.end_time = end_time;
        this.type = type;
        this.status = status;
        this.courses_course_id = courses_course_id;
        this.class_rooms_id = class_rooms_id;
        this.temp_bookings_id = temp_bookings_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(String day_of_week) {
        this.day_of_week = day_of_week;
    }

    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public LocalTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }

    public String getType() {
        return type;
    }

    public void SetType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCourses_course_id() {
        return courses_course_id;
    }

    public void setCourses_course_id(int courses_course_id) {
        this.courses_course_id = courses_course_id;
    }

    public int getClass_rooms_id() {
        return class_rooms_id;
    }

    public void setClass_rooms_id(int class_rooms_id) {
        this.class_rooms_id = class_rooms_id;
    }

    public int getTemp_bookings_id() {
        return temp_bookings_id;
    }

    public void setTemp_bookings_id(int temp_bookings_id) {
        this.temp_bookings_id = temp_bookings_id;
    }
}
