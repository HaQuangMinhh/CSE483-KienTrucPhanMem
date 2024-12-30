/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shoppingapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class ProductService {
    public void createProduct(String name, String description, double price) {
        String sql = "INSERT INTO Product (productName, productDescription, productPrice) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, description);
            pstmt.setDouble(3, price);
            pstmt.executeUpdate();
            System.out.println("Product created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View all products
    public void viewAllProducts() {
        String sql = "SELECT * FROM Product";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                System.out.printf("Product ID: %d, Name: %s, Price: %.2f%n",
                    rs.getInt("productId"),
                    rs.getString("productName"),
                    rs.getDouble("productPrice")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
