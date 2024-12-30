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
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderService {
   private final NotificationService notificationService;
    private final InventoryService inventoryService;

    public OrderService(NotificationService notificationService, InventoryService inventoryService) {
        this.notificationService = notificationService;
        this.inventoryService = inventoryService;
    }

    
    public void createOrder(String orderNumber, List<OrderLineItem> items) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
               
                boolean allAvailable = items.stream()
                    .allMatch(item -> inventoryService.checkAvailability(
                        Long.parseLong(item.getOrderLineSkuCode()), 
                        item.getQuantity()
                    ));

                if (!allAvailable) {
                    notificationService.sendMessage("Order fail");
                    return;
                }

              
                String orderSql = "INSERT INTO Orders (orderNumber) VALUES (?)";
                PreparedStatement orderStmt = conn.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS);
                orderStmt.setString(1, orderNumber);
                orderStmt.executeUpdate();

               
                ResultSet rs = orderStmt.getGeneratedKeys();
                long orderId = rs.next() ? rs.getLong(1) : 0;

               
                String itemSql = "INSERT INTO OrderLineItem (orderId, orderLineSkuCode, productPrice, quantity) VALUES (?, ?, ?, ?)";
                PreparedStatement itemStmt = conn.prepareStatement(itemSql);
                
                for (OrderLineItem item : items) {
                    itemStmt.setLong(1, orderId);
                    itemStmt.setString(2, item.getOrderLineSkuCode());
                    itemStmt.setBigDecimal(3, item.getProductPrice());
                    itemStmt.setInt(4, item.getQuantity());
                    itemStmt.executeUpdate();
                }

                conn.commit();
                notificationService.sendMessage("Order Placed successfully");
            } catch (SQLException e) {
                conn.rollback();
                notificationService.sendMessage("Order fail");
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    public void viewAllOrders() {
        String sql = "SELECT o.orderNumber, oli.orderLineSkuCode, oli.quantity, oli.productPrice " +
                    "FROM Orders o JOIN OrderLineItem oli ON o.orderId = oli.orderId";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                System.out.printf("Order: %s, Product: %s, Quantity: %d, Price: %.2f%n",
                    rs.getString("orderNumber"),
                    rs.getString("orderLineSkuCode"),
                    rs.getInt("quantity"),
                    rs.getDouble("productPrice")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
}
