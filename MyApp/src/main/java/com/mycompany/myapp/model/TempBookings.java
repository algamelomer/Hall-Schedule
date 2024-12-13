/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.model;

/**
 *
 * @author omar
 */
public class TempBookings {

    private int id;
    private String reason;
    private int users_id;
    private int class_rooms_id;

    public TempBookings() {

    }

    public TempBookings(int id, String reason, int users_id, int class_rooms_id) {
        this.id = id;
        this.reason = reason;
        this.users_id = users_id;
        this.class_rooms_id = class_rooms_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getClass_rooms_id() {
        return class_rooms_id;
    }

    public void setClass_rooms_id(int class_rooms_id) {
        this.class_rooms_id = class_rooms_id;
    }
}
