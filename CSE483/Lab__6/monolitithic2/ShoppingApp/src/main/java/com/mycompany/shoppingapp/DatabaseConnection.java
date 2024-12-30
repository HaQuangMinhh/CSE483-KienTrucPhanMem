/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shoppingapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DatabaseConnection {
     private static final String DB_URL = "jdbc:sqlite:shopping.db";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void initializeDatabase() {
        try (Connection conn = getConnection()) {
        
            conn.createStatement().execute(
                "CREATE TABLE IF NOT EXISTS Product (" +
                "productId INTEGER PRIMARY KEY," +
                "productName TEXT NOT NULL," +
                "productDescription TEXT," +
                "productPrice DECIMAL(10,2) NOT NULL)"
            );

          
            conn.createStatement().execute(
                "CREATE TABLE IF NOT EXISTS Orders (" +
                "orderId INTEGER PRIMARY KEY," +
                "orderNumber TEXT NOT NULL UNIQUE)"
            );

          
            conn.createStatement().execute(
                "CREATE TABLE IF NOT EXISTS OrderLineItem (" +
                "orderLineId INTEGER PRIMARY KEY," +
                "orderId INTEGER," +
                "orderLineSkuCode TEXT NOT NULL," +
                "productPrice DECIMAL(10,2) NOT NULL," +
                "quantity INTEGER NOT NULL," +
                "FOREIGN KEY (orderId) REFERENCES Orders(orderId))"
            );

         
            conn.createStatement().execute(
                "CREATE TABLE IF NOT EXISTS Inventory (" +
                "invId INTEGER PRIMARY KEY," +
                "productId INTEGER," +
                "quantity INTEGER NOT NULL," +
                "FOREIGN KEY (productId) REFERENCES Product(productId))"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
