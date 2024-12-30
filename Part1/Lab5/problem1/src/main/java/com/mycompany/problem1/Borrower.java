/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problem1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Borrower {
   private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private List<Book> borrowedBooks;

    public Borrower(String name, String address, String email, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new ArrayList<>();
    }

   
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }
    
     @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email + ", Phone: " + phoneNumber;
    }
}
