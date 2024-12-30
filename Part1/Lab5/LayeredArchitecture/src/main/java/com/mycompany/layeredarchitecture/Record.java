/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.layeredarchitecture;

/**
 *
 * @author Admin
 */
public class Record {
    private String borrowerName;
    private String bookTitle;

    public Record(String borrowerName, String bookTitle) {
        this.borrowerName = borrowerName;
        this.bookTitle = bookTitle;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public String getBookTitle() {
        return bookTitle;
    }
}
