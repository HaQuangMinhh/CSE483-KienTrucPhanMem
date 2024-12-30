/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.monolithic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class Monolithic {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Shopping Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

     
        JButton productButton = new JButton("Manage Products");
        JButton orderButton = new JButton("Order Service");
        JButton inventoryButton = new JButton("Check Inventory");

       
        JPanel panel = new JPanel();
        panel.add(productButton);
        panel.add(orderButton);
        panel.add(inventoryButton);

        frame.add(panel);
        frame.setVisible(true);

       
        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
                ProductManagement.display();
            }
        });

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderManagement.display();
            }
        });

        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                InventoryManagement.display();
            }
        });
    } 
    }

