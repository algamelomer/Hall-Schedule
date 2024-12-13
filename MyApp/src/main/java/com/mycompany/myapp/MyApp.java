package com.mycompany.myapp;

import com.mycompany.myapp.model.Users;
import com.mycompany.myapp.dashboard.UsersManagement;

public class MyApp {

    public static void main(String[] args) {
        //        Login loginForm = new Login();
        //        loginForm.setVisible(true);
        //        String[] headers = {"Student Name", "Status", "Start Time", "End Time", "Room"};
        //
        //        Object[][] rowData = {
        //            {"John Doe", "Present", "9:00 AM", "10:00 AM", "Room 101"},
        //            {"Jane Smith", "Absent", "10:30 AM", "11:30 AM", "Room 102"},
        //            {"Mark Johnson", "Present", "1:00 PM", "2:00 PM", "Room 101"}
        //        };
        //        TableData table = new TableData(headers, rowData);
        ////        TableData table = new TableData();
        ////
        //        table.setVisible(true);
        
        Users user = new Users(0, "omar", "example@example.com", "Admin", "password", "phone", 1);
        UsersManagement test = new UsersManagement(user);
        test.setVisible(true);

    }
}
