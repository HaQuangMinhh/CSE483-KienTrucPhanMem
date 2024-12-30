/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monolithic;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class InventoryManagement {
     public static void display() {
        JFrame frame = new JFrame("Place Order");
        frame.setSize(400, 300);

        JLabel label = new JLabel("Enter Product ID:");
        JTextField productIdField = new JTextField(10);
        JLabel quantityLabel = new JLabel("Enter Quantity:");
        JTextField quantityField = new JTextField(5);
        JButton placeOrderButton = new JButton("Place Order");

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(productIdField);
        panel.add(quantityLabel);
        panel.add(quantityField);
        panel.add(placeOrderButton);

        frame.add(panel);
        frame.setVisible(true);

       
        placeOrderButton.addActionListener(e -> {
            String productId = productIdField.getText();
            String quantity = quantityField.getText();
            if (!productId.isEmpty() && !quantity.isEmpty()) {
               
                JOptionPane.showMessageDialog(frame, "Order placed for product ID " + productId + " with quantity " + quantity);
            } else {
                JOptionPane.showMessageDialog(frame, "Please fill all fields!");
            }
        });
    }
}
