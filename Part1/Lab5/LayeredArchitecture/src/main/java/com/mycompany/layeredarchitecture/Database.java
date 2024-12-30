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
public class Database {
    
    ArrayList<Book> books;
    ArrayList<Borrower> borrowers;
    ArrayList<Record> records;

    public Database() {
        this.books = new ArrayList<>();
        this.borrowers = new ArrayList<>();
        this.records = new ArrayList<>();
    }

    Iterable<Borrower> getBorrowers() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
