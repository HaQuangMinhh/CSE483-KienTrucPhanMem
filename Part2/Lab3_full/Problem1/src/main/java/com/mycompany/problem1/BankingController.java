
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
public class BankingController {
     private List<Account> accounts;
    private BankingView view;

    public BankingController() {
        this.accounts = new ArrayList<>();
        this.view = new BankingView();
        initializeAccounts(); 
    }

    private void initializeAccounts() {
        User user1 = new User("John Smith", "password999099");
        User user2 = new User("Austin Agustus", "password595996");

        accounts.add(new Account("1001", user1, AccountType.CHECKING));
        accounts.add(new Account("1002", user1, AccountType.SAVINGS));
        accounts.add(new Account("1003", user2, AccountType.LOAN));
    }

    public boolean authenticateUser(String username, String password) {
        for (Account account : accounts) {
            User user = account.getOwner();
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                view.authenticateUser(user, account);
                return true;
            }
        }
        view.showError("Invalid credentials");
        return false;
    }

    public void deposit(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            if (account.getAccountType() == AccountType.LOAN) {
                view.showError("Deposits not allowed for loan accounts");
                return;
            }
            
            Transaction transaction = new Transaction(TransType.DEPOSIT, 
                "Deposit to account " + accountNumber, amount);
            account.addTransaction(transaction);
            view.printTransaction(transaction);
            view.printAccountDetails(account);
        }
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            if (account.getAccountType() != AccountType.CHECKING) {
                view.showError("Withdrawals only allowed for checking accounts");
                return;
            }
            
            if (account.getBalance() < amount) {
                view.showError("Insufficient funds");
                return;
            }

            Transaction transaction = new Transaction(TransType.WITHDRAWAL, 
                "Withdrawal from account " + accountNumber, amount);
            account.addTransaction(transaction);
            view.printTransaction(transaction);
            view.printAccountDetails(account);
        }
    }

    public void transactionLog(String accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("Transaction History for Account: " + accountNumber);
            for (Transaction transaction : account.getTransactions()) {
                view.printTransaction(transaction);
            }
        }
    }

    private Account findAccount(String accountNumber) {
        return accounts.stream().filter(a -> a.getAccountNumber().equals(accountNumber)).findFirst().orElse(null);
    }
}


   

     

    

