/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problem1;

/**
 *
 * @author Admin
 */
public class Record {
    private String borrowerName;
    private String bookTitle;
    private String borrowDate;

    public Record(String borrowerName, String bookTitle, String borrowDate) {
        this.borrowerName = borrowerName;
        this.bookTitle = bookTitle;
        this.borrowDate = borrowDate;
    }

   
    public String getBorrowerName() { return borrowerName; }
    public String getBookTitle() { return bookTitle; }
    public String getBorrowDate() { return borrowDate; }

    @Override
    public String toString() {
        return "Borrower: " + borrowerName + ", Book: " + bookTitle + ", Date: " + borrowDate;
    }
}
