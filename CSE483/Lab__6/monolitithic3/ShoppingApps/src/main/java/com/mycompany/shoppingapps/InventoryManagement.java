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
public class InventoryManagement {
 public static void display() {
        JFrame frame = new JFrame("Check Inventory");
        frame.setSize(400, 300);

        JLabel productIdLabel = new JLabel("Product ID:");
        JTextField productIdField = new JTextField(10);
        JButton checkButton = new JButton("Check Inventory");

        JPanel panel = new JPanel();
        panel.add(productIdLabel);
        panel.add(productIdField);
        panel.add(checkButton);

        frame.add(panel);
        frame.setVisible(true);

        checkButton.addActionListener(e -> {
            String productIdText = productIdField.getText();
            if (!productIdText.isEmpty()) {
                try (Connection conn = DatabaseUtils.connect();
                     PreparedStatement stmt = conn.prepareStatement("SELECT quantity FROM Inventory WHERE productID = ?")) {
                    stmt.setInt(1, Integer.parseInt(productIdText));
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(frame, "Quantity in stock: " + rs.getInt("quantity"));
                    } else {
                        JOptionPane.showMessageDialog(frame, "Product not found in inventory!");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Product ID cannot be empty!");
            }
        });
    }   
}
