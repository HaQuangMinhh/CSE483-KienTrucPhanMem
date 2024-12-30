/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shoppingapps;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class DatabaseUtils {
  public static Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:shopping.db");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }   
}
