/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.shoppingapp;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class ShoppingApp {

    public static void main(String[] args) {
         DatabaseConnection.initializeDatabase();

        // Initialize services
        ProductService productService = new ProductService();
        InventoryService inventoryService = new InventoryService();
        NotificationService notificationService = new NotificationService();
        OrderService orderService = new OrderService(notificationService, inventoryService);

       
        System.out.println("=== Product Service Demo ===");
        productService.createProduct("Laptop", "High-end laptop", 999.99);
        productService.viewAllProducts();

       
        System.out.println("\n=== Inventory Service Demo ===");
        inventoryService.registerProduct(1, 5);
        inventoryService.checkAvailability(1, 2);

        
        System.out.println("\n=== Order Service Demo ===");
        OrderLineItem orderItem = new OrderLineItem(1L, "1", new BigDecimal("999.99"), 1);
        orderService.createOrder("ORD001", Arrays.asList(orderItem));
        orderService.viewAllOrders();
    }  
    }

