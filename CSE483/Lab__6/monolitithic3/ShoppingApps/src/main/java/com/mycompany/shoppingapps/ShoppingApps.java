/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.shoppingapps;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class ShoppingApps {

    public static void main(String[] args) {
       JFrame frame = new JFrame("Shopping Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JButton manageProductsButton = new JButton("Manage Products");
        JButton placeOrderButton = new JButton("Place Order");
        JButton checkInventoryButton = new JButton("Check Inventory");

        JPanel panel = new JPanel();
        panel.add(manageProductsButton);
        panel.add(placeOrderButton);
        panel.add(checkInventoryButton);

        frame.add(panel);
        frame.setVisible(true);

        manageProductsButton.addActionListener(e -> ProductManagement.display());
        placeOrderButton.addActionListener(e -> OrderManagement.display());
        checkInventoryButton.addActionListener(e -> InventoryManagement.display());
    } 
    }

