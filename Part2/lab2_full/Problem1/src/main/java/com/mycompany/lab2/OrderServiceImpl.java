/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab2;

import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderServiceImpl implements OrderService {
    
    @Override
    public void placeOrder(String username, List<Product> products) {
        System.out.println("Order placed by: " + username);
        System.out.println("Products in the order:");
        for (Product product : products) {
            System.out.println("- " + product.getName());
        }
    }
} 

