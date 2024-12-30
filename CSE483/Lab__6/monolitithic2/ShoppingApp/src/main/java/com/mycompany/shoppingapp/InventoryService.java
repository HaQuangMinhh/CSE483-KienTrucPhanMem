/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shoppingapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class InventoryService {
  public void registerProduct(long productId, int quantity) {
        String sql = "INSERT INTO Inventory (productId, quantity) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, productId);
            pstmt.setInt(2, quantity);
            pstmt.executeUpdate();
            System.out.println("Product registered in inventory successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Check product availability
    public boolean checkAvailability(long productId, int requestedQuantity) {
        String sql = "SELECT quantity FROM Inventory WHERE productId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, productId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                int availableQuantity = rs.getInt("quantity");
                boolean isAvailable = availableQuantity >= requestedQuantity;
                System.out.println(isAvailable ? "Product in stock" : "Product out of stock");
                return isAvailable;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }  
}
