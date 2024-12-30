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
public class ECommerceApp {
     private final UserService userService;
    private final OrderService orderService;
    private final PaymentService paymentService;

    public ECommerceApp(UserService userService, OrderService orderService, PaymentService paymentService) {
        this.userService = userService;
        this.orderService = orderService;
        this.paymentService = paymentService;
    }

    public void makePurchase(String username, String password, List<Product> products) {
        if (userService.authenticateUser(username, password)) {
            orderService.placeOrder(username, products);
            paymentService.processPayment(products);
        } else {
            System.out.println("Authentication failed.");
        }
    }
}
