/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.layeredarchitecture;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Borrower {
      private String name;
    private String address;
    private String email;
    private String phone;
    private ArrayList<Book> borrowedBooks;

    public Borrower(String name, String address, String email, String phone) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
