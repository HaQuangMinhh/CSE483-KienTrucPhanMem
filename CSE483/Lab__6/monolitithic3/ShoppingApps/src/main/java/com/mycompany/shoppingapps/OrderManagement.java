/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shoppingapps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class OrderManagement {
 public static void display() {
        JFrame frame = new JFrame("Place Order");
        frame.setSize(400, 300);

        JLabel productIdLabel = new JLabel("Product ID:");
        JTextField productIdField = new JTextField(10);
        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityField = new JTextField(5);
        JButton orderButton = new JButton("Place Order");

        JPanel panel = new JPanel();
        panel.add(productIdLabel);
        panel.add(productIdField);
        panel.add(quantityLabel);
        panel.add(quantityField);
        panel.add(orderButton);

        frame.add(panel);
        frame.setVisible(true);

        orderButton.addActionListener(e -> {
            String productIdText = productIdField.getText();
            String quantityText = quantityField.getText();
            if (!productIdText.isEmpty() && !quantityText.isEmpty()) {
                try (Connection conn = DatabaseUtils.connect();
                     PreparedStatement checkStmt = conn.prepareStatement("SELECT quantity FROM Inventory WHERE productID = ?");
                     PreparedStatement updateStmt = conn.prepareStatement("UPDATE Inventory SET quantity = quantity - ? WHERE productID = ?")) {
                    checkStmt.setInt(1, Integer.parseInt(productIdText));
                    ResultSet rs = checkStmt.executeQuery();
                    if (rs.next() && rs.getInt("quantity") >= Integer.parseInt(quantityText)) {
                        updateStmt.setInt(1, Integer.parseInt(quantityText));
                        updateStmt.setInt(2, Integer.parseInt(productIdText));
                        updateStmt.executeUpdate();
                        JOptionPane.showMessageDialog(frame, "Order placed successfully!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Not enough stock available!");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(frame, "All fields must be filled!");
            }
        });
    }   
}
