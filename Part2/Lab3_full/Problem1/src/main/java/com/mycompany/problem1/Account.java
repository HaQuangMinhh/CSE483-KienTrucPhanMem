/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problem1;


import com.mycompany.problem1.Model.AccountType;
import com.mycompany.problem1.Model.TransType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Account {
    private String accountNumber;
    private double balance;
    private User owner;
    private AccountType accountType;
    private List<Transaction> transactions;
    
     public Account(String accountNumber, User owner, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.accountType = accountType;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public User getOwner() {
        return owner;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        if (transaction.getType() == TransType.DEPOSIT) {
            balance += transaction.getAmount();
        } else {
            balance -= transaction.getAmount();
        }
    }
    
}
