/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problem1;

import com.mycompany.problem1.Model.TransType;
import java.time.LocalDateTime;

/**
 *
 * @author Admin
 */
class Transaction {
   private TransType type;
    private String description;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(TransType type, String description, double amount) {
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public TransType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    } 
}
