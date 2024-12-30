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
public class ProductManagement {
  public static void display() {
        JFrame frame = new JFrame("Manage Products");
        frame.setSize(400, 300);

        JLabel nameLabel = new JLabel("Product Name:");
        JTextField nameField = new JTextField(20);
        JLabel priceLabel = new JLabel("Product Price:");
        JTextField priceField = new JTextField(10);
        JButton addButton = new JButton("Add Product");
        JButton viewButton = new JButton("View Products");

        JPanel panel = new JPanel();
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(addButton);
        panel.add(viewButton);

        frame.add(panel);
        frame.setVisible(true);

        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String priceText = priceField.getText();
            if (!name.isEmpty() && !priceText.isEmpty()) {
                try (Connection conn = DatabaseUtils.connect();
                     PreparedStatement stmt = conn.prepareStatement("INSERT INTO Product (productName, productPrice) VALUES (?, ?)")) {
                    stmt.setString(1, name);
                    stmt.setDouble(2, Double.parseDouble(priceText));
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(frame, "Product added successfully!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(frame, "All fields must be filled!");
            }
        });

        viewButton.addActionListener(e -> {
            try (Connection conn = DatabaseUtils.connect();
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Product");
                 ResultSet rs = stmt.executeQuery()) {
                StringBuilder productList = new StringBuilder("Products:\n");
                while (rs.next()) {
                    productList.append("ID: ").append(rs.getInt("productId"))
                            .append(", Name: ").append(rs.getString("productName"))
                            .append(", Price: ").append(rs.getDouble("productPrice"))
                            .append("\n");
                }
                JOptionPane.showMessageDialog(frame, productList.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }  
}
