/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab2;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Lab2 {

    public static void main(String[] args) {
       UserService user = new UserServiceImpl();
        OrderService order = new OrderServiceImpl();
        PaymentService payment = new PaymentServiceImpl();

        ECommerceApp InforProduct = new ECommerceApp(user, order, payment);

       
        List<Product> products = Arrays.asList(
            new Product(1, "Iphone 16 ProMax", 1499.0),
            new Product(2, "Laptop Gaming", 549.0),
            new Product(3, "Camera", 789.0),
            new Product(4, "Smart Watch", 276.0),
            new Product(5, "Computer ", 1387.0)
        );

        InforProduct.makePurchase("John Smith", "johnsmith123@", products);
    }
    }
