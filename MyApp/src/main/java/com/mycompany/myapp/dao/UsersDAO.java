package com.mycompany.myapp.dao;

import com.mycompany.myapp.model.Users;
import com.mycompany.myapp.DatabaseConnection;
import com.mycompany.myapp.methods.HashPassword;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UsersDAO {

    public List<Users> getAllUsers() {
        // Logic for fetching all users from the 'users' table
        return null;
    }

    public Users login(String email, String password) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, email);
            pstmt.setString(2, HashPassword.hashPassword(password));

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Users(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("role"),
                        rs.getString("password"),
                        rs.getString("phone"),
                        rs.getInt("departments_departments_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if no user is found
    }

    public void addUser(Users user) {
        String query = "INSERT INTO users (name, email, role, password, phone, departments_departments_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getRole());
            pstmt.setString(4, HashPassword.hashPassword(user.getPassword()));
            pstmt.setString(5, user.getPhone());
            pstmt.setInt(6, user.getDepartmentId());

            pstmt.executeUpdate();
            System.out.println("User added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(Users user) {
        String query = "UPDATE users SET name = ?, email = ?, role = ?, password = ?, phone = ?, departments_departments_id = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getRole());
            pstmt.setString(4, HashPassword.hashPassword(user.getPassword()));
            pstmt.setString(5, user.getPhone());
            pstmt.setInt(6, user.getDepartmentId());
            pstmt.setInt(7, user.getId());

            pstmt.executeUpdate();
            System.out.println("User updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        String query = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);

            pstmt.executeUpdate();
            System.out.println("User deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
