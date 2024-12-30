/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monolithic;

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
        JFrame frame = new JFrame("Product Management");
        frame.setSize(400, 300);

        JLabel label = new JLabel("Enter Product Name:");
        JTextField productNameField = new JTextField(20);
        JButton addButton = new JButton("Add Product");
        JButton viewButton = new JButton("View Products");

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(productNameField);
        panel.add(addButton);
        panel.add(viewButton);

        frame.add(panel);
        frame.setVisible(true);

     
        addButton.addActionListener(e -> {
            String productName = productNameField.getText();
            if (!productName.isEmpty()) {
              
                JOptionPane.showMessageDialog(frame, "Product " + productName + " added!");
                productNameField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Product name cannot be empty!");
            }
        });

        
        viewButton.addActionListener(e -> {
           
            JOptionPane.showMessageDialog(frame, "Displaying products...");
        });
    } 
}
    

