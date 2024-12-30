/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problem1;

/**
 *
 * @author Admin
 */
public class BankingView {
    public void authenticateUser(User user, Account account) {
        System.out.println("Welcome, " + user.getUsername() + "!");
        printAccountDetails(account);
    }

    public void printTransaction(Transaction transaction) {
        System.out.println("Transaction Type: " + transaction.getType());
        System.out.println("Amount: $" + transaction.getAmount());
        System.out.println("Description: " + transaction.getDescription());
        System.out.println("Timestamp: " + transaction.getTimestamp());
        System.out.println("------------------------");
    }

    public void printAccountDetails(Account account) {
        System.out.println("Account Details:");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Type: " + account.getAccountType());
        System.out.println("Current Balance: $" + account.getBalance());
        System.out.println("------------------------");
    }

    public void showError(String message) {
        System.out.println("Error: " + message);
    } 
}
